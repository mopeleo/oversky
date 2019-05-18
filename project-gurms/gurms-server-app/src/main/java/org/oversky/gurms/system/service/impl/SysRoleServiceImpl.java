package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.dao.SysRoleDao;
import org.oversky.gurms.system.dao.SysRoleMenuDao;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.entity.SysRoleMenu;
import org.oversky.gurms.system.ext.dao.UniqueCheckDao;
import org.oversky.gurms.system.ext.dao.UserRightDao;
import org.oversky.gurms.system.service.SysRoleService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.valid.GSAValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	private static final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);

	@Autowired
	private SysRoleDao roleDao;
	
	@Autowired
	private SysRoleMenuDao roleMenuDao;
	
	@Autowired
	private UniqueCheckDao uniqueDao;
	
	@Autowired
	private UserRightDao userRightDao;
	
	@Override
	@GSAValid(type=SysRoleReq.class)
	@Transactional
	public SysRoleRes insert(SysRoleReq roleReq) {
		log.info("开始角色新增......");
		SysRoleRes res = new SysRoleRes();
		//rolename 唯一性检查
		if(uniqueDao.existRoleName(roleReq.getRolename()) > 0) {
			res.failure("角色名称["+roleReq.getRolename()+"]已存在");
			log.info("新增角色失败 : {}", res.getReturnmsg());
			return res;
		}

		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		if(roleDao.insert(role) != 1) {
			res.failure("插入数据库失败");
			log.info("新增角色失败 : {}", res.getReturnmsg());
			return res;
		}
		
		freshRoleMenus(role.getRoleid(), roleReq.getMenulist());		
		res.success("新增角色成功");
		log.info("新增角色[roleid={}]结束: {}", role.getRoleid(), res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public boolean delete(Long roleid) {
		log.info("开始删除角色[roleid={}]信息...", roleid);
		int rows = roleDao.deleteById(roleid);
		if( rows == 0) {
			log.info("删除角色[roleid={}]失败：角色信息不存在", roleid);
			return false;
		}
		if(rows > 1) {
			log.info("删除角色[roleid={}]失败：角色信息不唯一", roleid);
			throw new BaseServiceException("删除角色[roleid=" + roleid + "]失败：角色信息不唯一");
		}
		
		SysRoleMenu where = new SysRoleMenu();
		where.setRoleid(roleid);
		roleMenuDao.deleteWhere(where);
		log.info("删除角色[roleid={}]成功", roleid);
		return true;
	}

	@Override
	@Transactional
	public SysRoleRes update(SysRoleReq roleReq) {
		log.info("开始修改角色[roleid={}]信息......", roleReq.getRoleid());
		SysRoleRes res = new SysRoleRes();
		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		int rows = roleDao.updateById(role);
		if(rows == 0) {
			res.failure("更新角色[roleid={}]失败：角色信息不存在");
			log.info("修改角色失败 : {}", res.getReturnmsg());
			return res;
		}
		if(rows > 1) {
			log.info("更新角色[roleid={}]失败：角色信息不唯一", role.getRoleid());
			throw new BaseServiceException("更新角色[roleid=" + role.getRoleid() + "]失败：角色信息不唯一");
		}
		
		SysRoleMenu where = new SysRoleMenu();
		where.setRoleid(role.getRoleid());
		roleMenuDao.deleteWhere(where);
		freshRoleMenus(role.getRoleid(), roleReq.getMenulist());
		
		res.success("修改角色成功");
		log.info("修改角色[roleid={}]结束: {}", role.getRoleid(), res.getReturnmsg());
		return res;
	}
	
	@Override
	public SysRoleRes getById(Long roleid) {
		log.info("开始查询角色[roleid={}]信息...", roleid);
		SysRole role = roleDao.getById(roleid);
		SysRoleRes res = new SysRoleRes();
		if(role == null) {
			res.failure("角色不存在");
		}else {
			BeanCopyUtils.copy(role, res);
			String menuList = getElementUIMenuList(roleid);
			res.setMenulist(menuList);
		}
		log.info("查询角色[roleid={}]结束: {}", roleid, res.getReturnmsg());
		return res;
	}

	@Override
	public BaseResListDto<SysRoleRes> pageSysRole(SysRoleReq roleReq) {
		log.info("开始分页查询角色信息...");
		Page<SysRole> page = PageHelper.startPage(roleReq.getPageNum(), roleReq.getPageSize());
		SysRole where = BeanCopyUtils.convert(roleReq, SysRole.class);
		List<SysRole> roleList = roleDao.selectWhere(where);
		List<SysRoleRes> roleResList = BeanCopyUtils.convertList(roleList, SysRoleRes.class);
		
		BaseResListDto<SysRoleRes> resList = new BaseResListDto<SysRoleRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询角色信息结束，共查询到{}条", roleList.size());
		return resList;
	}

	private void freshRoleMenus(Long roleId, String menuList) {
		if(!StringUtils.isEmpty(menuList)) {
			String[] menus = menuList.split(",");
			List<SysRoleMenu> rolemenuList = new ArrayList<>(menus.length);
			for(String menuId: menus) {
				SysRoleMenu roleMenu = new SysRoleMenu();
				roleMenu.setMenuid(menuId);
				roleMenu.setRoleid(roleId);
				
				rolemenuList.add(roleMenu);
			}
			if(roleMenuDao.insertBatch(rolemenuList) != rolemenuList.size()) {
				throw new BaseServiceException("更新角色[" + roleId + "]权限映射关系失败");
			}
		}
	}
	
	private String getMenuList(Long roleid) {
		String menus = null;
		List<SysMenu> menuList = userRightDao.getRoleMenus(roleid);
		if(menuList != null && menuList.size() > 0) {
			menus = "";
			for(SysMenu menu : menuList) {
				menus += menu.getMenuid() + ",";
			}
			if(menus.length() > 0) {
				menus = menus.substring(0, menus.length() - 1);
			}
		}
		return menus;
	}
	
	private String getElementUIMenuList(Long roleid) {
		String menus = null;
		List<SysMenu> menuList = userRightDao.getRoleMenus(roleid);
		if(menuList != null && menuList.size() > 0) {
			//全部菜单ID
			List<String> allMenu = new ArrayList<>();
			for(SysMenu menu : menuList) {
				allMenu.add(menu.getMenuid());
			}
			//排除掉有子菜单的menuid
			for(SysMenu menu : menuList) {
				if(menu.getParentmenu() != null && allMenu.contains(menu.getParentmenu())) {
					allMenu.remove(menu.getParentmenu());
				}
			}
			menus = String.join(",", allMenu);
		}
		return menus;
	}
}

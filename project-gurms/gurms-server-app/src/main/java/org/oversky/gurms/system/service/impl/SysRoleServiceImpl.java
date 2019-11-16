package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.dao.SysRoleDao;
import org.oversky.gurms.system.dao.SysRoleMenuDao;
import org.oversky.gurms.system.dao.SysUserRoleDao;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.entity.SysRoleMenu;
import org.oversky.gurms.system.entity.SysUserRole;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
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
	private SysUserRoleDao userRoleDao;
	
	@Autowired
	private UserRightDao userRightDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;

	@Override
	@GSAValid(type=SysRoleReq.class)
	@Transactional
	public SysRoleRes insert(SysRoleReq roleReq) {
		log.info("开始角色新增......");
		SysRoleRes res = new SysRoleRes();
		//rolename 唯一性检查
		SysRole role = new SysRole();
		role.setRolename(roleReq.getRolename());
		if(roleDao.count(role) > 0) {
			res.failure("角色名称["+roleReq.getRolename()+"]已存在");
			log.warn("新增角色失败 : {}", res.getReturnmsg());
			return res;
		}

		BeanCopyUtils.copy(roleReq, role);
		if(roleDao.insert(role) != 1) {
			res.failure("插入数据库失败");
			log.warn("新增角色失败 : {}", res.getReturnmsg());
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
		roleDao.deleteById(roleid);
		
		SysRoleMenu srmWhere = new SysRoleMenu();
		srmWhere.setRoleid(roleid);
		roleMenuDao.deleteWhere(srmWhere);
		
		SysUserRole surWhere = new SysUserRole();
		surWhere.setRoleid(roleid);
		userRoleDao.deleteWhere(surWhere);
		
		log.info("删除角色[roleid={}]成功", roleid);
		return true;
	}

	@Override
	@Transactional
	public SysRoleRes update(SysRoleReq roleReq) {
		log.info("开始修改角色[roleid={}]信息......", roleReq.getRoleid());
		SysRoleRes res = new SysRoleRes();
		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		roleDao.updateById(role);
		
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
			log.warn(res.getReturnmsg());
			return res;
		}else {
			BeanCopyUtils.copy(role, res);
			String menuList = getElementUIMenuList(roleid);
			res.setMenulist(menuList);
			res.success();
		}
		log.info("查询角色[roleid={}]结束: {}", roleid, res.getReturnmsg());
		return res;
	}

	@Override
	public BaseResListDto<SysRoleRes> getCanGrantRoles(Long userid, String unioncode) {
		List<SysRole> roles = userRightDao.getUserCanGrantRoles(userid, unioncode);
		List<SysRoleRes> roleResList = BeanCopyUtils.convertList(roles, SysRoleRes.class);
		BaseResListDto<SysRoleRes> resList = new BaseResListDto<SysRoleRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		return resList;
	}
	
	@Override
	public BaseResListDto<SysRoleRes> userRoles(Long userid) {
		List<SysRole> roles = userRightDao.getUserRoles(userid);
		List<SysRoleRes> roleResList = BeanCopyUtils.convertList(roles, SysRoleRes.class);
		BaseResListDto<SysRoleRes> resList = new BaseResListDto<SysRoleRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		return resList;
	}
	
	@Override
	public BaseResListDto<SysRoleRes> pageSysRole(SysRoleReq roleReq) {
		log.info("开始分页查询角色信息...");
		Page<SysRole> page = PageHelper.startPage(roleReq.getPageNum(), roleReq.getPageSize());
		SysRole where = BeanCopyUtils.convert(roleReq, SysRole.class);
		if(StringUtils.isEmpty(where.getCreator())) {
			where.setCreator(roleReq.getOperator());
		}
		List<SysRole> roleList = pageQueryDao.findRoles(where);
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
				log.error("更新角色[{}]权限映射关系失败", roleId);
				throw new BaseServiceException("更新角色[" + roleId + "]权限映射关系失败");
			}
		}
	}
	
	private String getMenuList(Long roleid) {
		String menus = null;
		SysRoleMenu where = new SysRoleMenu();
		where.setRoleid(roleid);
		List<SysRoleMenu> menuList = roleMenuDao.selectWhere(where);
		if(menuList != null && menuList.size() > 0) {
			menus = "";
			for(SysRoleMenu menu : menuList) {
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

package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.oversky.base.service.BaseResListDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author Blue
 *
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

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
		SysRoleRes res = new SysRoleRes();
		//rolename 唯一性检查
		if(uniqueDao.existRoleName(roleReq.getRolename()) > 0) {
			res.failure("角色名称["+roleReq.getRolename()+"]已存在");
			return res;
		}

		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);
		if(roleDao.insert(role) != 1) {
			res.failure("新增角色失败");
			return res;
		}
		
		if(!deleteRoleMenus(role.getRoleid(), roleReq.getMenulist())) {
			res.failure("新增角色菜单映射关系失败");
			return res;
		}
		
		res.success("新增角色成功");
		return res;
	}

	@Override
	@Transactional
	public boolean delete(Long roleid) {
		if(roleDao.deleteById(roleid) != 1) {
			return false;
		}
		
		SysRoleMenu where = new SysRoleMenu();
		where.setRoleid(roleid);
		roleMenuDao.deleteWhere(where);
		return true;
	}

	@Override
	@Transactional
	public SysRoleRes update(SysRoleReq roleReq) {
		SysRoleRes res = new SysRoleRes();
		SysRole role = BeanCopyUtils.convert(roleReq, SysRole.class);		
		if(roleDao.updateById(role) != 1) {
			res.failure("修改角色失败");
			return res;
		}
		
		SysRoleMenu where = new SysRoleMenu();
		where.setRoleid(role.getRoleid());
		roleMenuDao.deleteWhere(where);

		if(!deleteRoleMenus(role.getRoleid(), roleReq.getMenulist())) {
			res.failure("修改角色菜单映射关系失败");
			return res;
		}
		
		res.success("修改角色成功");
		return res;
	}
	
	@Override
	public SysRoleRes getById(Long roleid) {
		SysRoleRes role = BeanCopyUtils.convert(roleDao.getById(roleid), SysRoleRes.class);
		List<SysMenu> menuList = userRightDao.getRoleMenus(roleid);
		if(menuList != null && menuList.size() > 0) {
			String menus = "";
			for(SysMenu menu : menuList) {
				menus += menu.getMenuid() + ",";
			}
			if(menus.length() > 0) {
				menus = menus.substring(0, menus.length() - 1);
			}
			role.setMenulist(menus);
		}
		return role;
	}

	@Override
	public BaseResListDto<SysRoleRes> pageSysRole(SysRoleReq roleReq) {
		Page<SysRole> page = PageHelper.startPage(roleReq.getPageNum(), roleReq.getPageSize());
		SysRole where = BeanCopyUtils.convert(roleReq, SysRole.class);
		List<SysRole> roleList = roleDao.selectWhere(where);
		List<SysRoleRes> roleResList = BeanCopyUtils.convertList(roleList, SysRoleRes.class);
		
		BaseResListDto<SysRoleRes> resList = new BaseResListDto<SysRoleRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		return resList;
	}

	private boolean deleteRoleMenus(Long roleId, String menuList) {
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
				return false;
			}
		}
		return true;
	}
}

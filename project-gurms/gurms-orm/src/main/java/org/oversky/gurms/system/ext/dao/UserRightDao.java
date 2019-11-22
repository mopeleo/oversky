package org.oversky.gurms.system.ext.dao;

import java.util.List;
import java.util.Map;

import org.oversky.gurms.system.entity.SysMenu;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.gurms.system.ext.bo.SysUserBO;

public interface UserRightDao {

	List<Map<String, Object>> testUserRoles(Map<String, Object> query);
	
	SysUserBO getUserRolesAndMenus(Long userid);
	
	List<SysMenu> getUserMenus(Long userid);

	List<SysRole> getUserRoles(Long userid);

	List<SysMenu> getRoleMenus(Long roleid);

	List<SysMenu> getSubMenus(String menuid);
	
}

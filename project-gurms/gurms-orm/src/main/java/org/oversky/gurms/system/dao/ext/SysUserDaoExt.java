package org.oversky.gurms.system.dao.ext;

import java.util.List;
import java.util.Map;

import org.oversky.gurms.system.dao.ext.bo.SysUserBO;
import org.oversky.gurms.system.entity.SysMenu;

public interface SysUserDaoExt {

	List<Map<String, Object>> testUserRoles(Map<String, Object> query);
	
	SysUserBO getUserRolesAndMenus(Long userid);
	
	List<SysMenu> getUserMenus(Long userid);

	List<SysMenu> getRoleMenus(Long roleid);

	List<SysMenu> getSubMenus(String menuid);
}

package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseService;
import org.oversky.gurms.system.dto.response.SysMenuRes;

public interface SysMenuService extends BaseService{

	SysMenuRes getMenu(String menuId, boolean tree);
	
	SysMenuRes getUserMenuTree(Long userId);
	
	SysMenuRes getRoleMenuTree(Long roleId);
	
	boolean isCorrectUrl(String url);
	
	SysMenuRes getMenuByUrl(String url);
}

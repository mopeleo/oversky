package org.oversky.gurms.system.controller;

import org.oversky.gurms.system.dto.request.SysMenuReq;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {
	@Autowired
	private SysMenuService menuService;
	
	@RequestMapping("/detail/{menuId}")
	public SysMenuRes detail(@PathVariable String menuId) {
		return menuService.getMenu(menuId, false);
	}

	@RequestMapping("/tree")
	public SysMenuRes tree(@RequestBody SysMenuReq menuReq) {
		return menuService.getFullMenuTree();
	}

}

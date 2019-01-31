package org.oversky.gurms.system.controller;

import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {
	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/detail")
	public SysUserRes detail(Long userid) {
		return userService.getById(userid);
	}

}

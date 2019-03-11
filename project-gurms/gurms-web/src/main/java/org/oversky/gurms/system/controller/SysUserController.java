package org.oversky.gurms.system.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping("/save")
	public SysUserRes save(@RequestBody SysUserReq userReq) {
		SysUserRes res = null;
		if(userReq.getUserid() == null) {
			res = userService.insert(userReq);
		}else {
			res = userService.update(userReq);
		}
		return res;
	}

	@RequestMapping("/list")
	public BaseResListDto<SysUserRes> list(@RequestBody SysUserReq userReq) {
		return userService.pageSysUser(userReq);
	}

	@RequestMapping("/delete/{userId}")
	public SysUserRes delete(@PathVariable Long userId) {
		return userService.delete(userId);
	}
}

package org.oversky.gurms.system.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/add")
	public SysUserRes add(@RequestBody SysUserReq userReq) {
		return userService.insert(userReq);
	}

	@RequestMapping("/update")
	public SysUserRes update(@RequestBody SysUserReq userReq) {
		return userService.update(userReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<SysUserRes> list(@RequestBody SysUserReq userReq) {
		return userService.pageSysUser(userReq);
	}

	@RequestMapping("/delete")
	public SysUserRes delete(@RequestBody SysUserReq userReq) {
		return userService.delete(userReq);
	}

	@RequestMapping("/resetpassword")
	public SysUserRes resetPassword(@RequestBody SysUserReq userReq) {
		return userService.resetPassword(userReq);
	}

	@RequestMapping("/updatepassword")
	public SysUserRes updatePassword(@RequestBody SysUserReq userReq) {
		return userService.updatePassword(userReq);
	}

	@RequestMapping("/freeze")
	public SysUserRes freeze(@RequestBody SysUserReq userReq) {
		return userService.freezeUser(userReq);
	}

	@RequestMapping("/unfreeze")
	public SysUserRes unfreeze(@RequestBody SysUserReq userReq) {
		return userService.unfreezeUser(userReq);
	}

	@RequestMapping("/grantrole")
	public SysUserRes grantRole(@RequestBody SysUserReq userReq) {
		return userService.grantRole(userReq);
	}
}

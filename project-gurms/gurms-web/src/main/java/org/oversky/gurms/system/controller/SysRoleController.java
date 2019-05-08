package org.oversky.gurms.system.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysrole")
public class SysRoleController {
	@Autowired
	private SysRoleService roleService;
	
	@RequestMapping("/detail/{roleId}")
	public SysRoleRes detail(@PathVariable Long roleId) {
		return roleService.getById(roleId);
	}

	@RequestMapping("/add")
	public SysRoleRes add(@RequestBody SysRoleReq roleReq) {
		return roleService.insert(roleReq);
	}

	@RequestMapping("/update")
	public SysRoleRes update(@RequestBody SysRoleReq roleReq) {
		return roleService.update(roleReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<SysRoleRes> list(@RequestBody SysRoleReq roleReq) {
		return roleService.pageSysRole(roleReq);
	}

	@RequestMapping("/delete/{roleId}")
	public boolean delete(@PathVariable Long roleId) {
		return roleService.delete(roleId);
	}
}

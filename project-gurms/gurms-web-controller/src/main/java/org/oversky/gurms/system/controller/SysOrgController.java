package org.oversky.gurms.system.controller;

import org.oversky.gurms.system.dto.request.SysOrgReq;
import org.oversky.gurms.system.dto.response.SysOrgRes;
import org.oversky.gurms.system.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysorg")
public class SysOrgController {
	@Autowired
	private SysOrgService orgService;
	
	@RequestMapping("/detail/{orgId}")
	public SysOrgRes detail(@PathVariable Long orgId) {
		return orgService.getById(orgId);
	}

	@RequestMapping("/add")
	public SysOrgRes add(@RequestBody SysOrgReq orgReq) {
		return orgService.insert(orgReq);
	}

	@RequestMapping("/update")
	public SysOrgRes update(@RequestBody SysOrgReq orgReq) {
		return orgService.update(orgReq);
	}

	@RequestMapping("/tree")
	public SysOrgRes tree(@RequestBody SysOrgReq orgReq) {
		return orgService.orgTree(orgReq);
	}

	@RequestMapping("/delete")
	public SysOrgRes delete(@RequestBody SysOrgReq orgReq) {
		return orgService.delete(orgReq);
	}
}

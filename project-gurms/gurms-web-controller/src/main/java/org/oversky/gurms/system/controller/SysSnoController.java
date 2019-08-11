package org.oversky.gurms.system.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysSnoReq;
import org.oversky.gurms.system.dto.response.SysSnoRes;
import org.oversky.gurms.system.service.SysSnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/syssno")
public class SysSnoController {

	@Autowired
	private SysSnoService snoService;
	
	@RequestMapping("/detail")
	public SysSnoRes detail(String unioncode, Integer noid) {
		return snoService.getById(unioncode, noid);
	}

	@RequestMapping("/update")
	public SysSnoRes update(@RequestBody SysSnoReq snoReq) {
		return snoService.update(snoReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<SysSnoRes> list(@RequestBody SysSnoReq snoReq) {
		return snoService.pageSysSno(snoReq);
	}

}

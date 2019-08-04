package org.oversky.gurms.system.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysParamReq;
import org.oversky.gurms.system.dto.response.SysParamInfoRes;
import org.oversky.gurms.system.dto.response.SysParamRes;
import org.oversky.gurms.system.service.SysParamService;
import org.oversky.gurms.web.util.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysparam")
public class SysParamController {
	
	@Autowired
	private SysParamService paramService;

	@RequestMapping("/getlist")
	public BaseResListDto<SysParamRes> getList(String unioncode, String paramids) {
		if(StringUtils.isEmpty(unioncode)) {
			unioncode = WebContext.getUserSession().getUnioncode();
		}
		return paramService.getParamList(unioncode, paramids);
	}
	
	@RequestMapping("/getparam/{paramid}/{unioncode}")
	public SysParamRes getParam(@PathVariable String unioncode, @PathVariable Integer paramid) {
		if(StringUtils.isEmpty(unioncode)) {
			unioncode = WebContext.getUserSession().getUnioncode();
		}
		return paramService.getParam(unioncode, paramid);
	}

	@RequestMapping("/reset/{unioncode}")
	public SysParamRes reset(@PathVariable String unioncode) {
		if(StringUtils.isEmpty(unioncode)) {
			unioncode = WebContext.getUserSession().getUnioncode();
		}
		return paramService.reset(unioncode);
	}

	@RequestMapping("/update")
	public SysParamRes update(@RequestBody SysParamReq paramReq) {
		if(StringUtils.isEmpty(paramReq.getUnioncode())) {
			String unioncode = WebContext.getUserSession().getUnioncode();
			paramReq.setUnioncode(unioncode);
		}
		return paramService.update(paramReq);
	}

	@RequestMapping("/page/{unioncode}")
	public BaseResListDto<SysParamInfoRes> paramPage(@PathVariable String unioncode) {
		if(StringUtils.isEmpty(unioncode)) {
			unioncode = WebContext.getUserSession().getUnioncode();
		}
		return paramService.paramInfoList(unioncode);
	}
}

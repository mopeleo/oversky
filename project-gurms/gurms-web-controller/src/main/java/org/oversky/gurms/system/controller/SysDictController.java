package org.oversky.gurms.system.controller;

import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.gurms.system.dto.request.SysDictReq;
import org.oversky.gurms.system.dto.response.SysDictRes;
import org.oversky.gurms.system.service.SysDictService;
import org.oversky.gurms.web.util.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysdict")
public class SysDictController {
	
	@Autowired
	private SysDictService dictService;

	@RequestMapping("/getlist/{dictcode}/{unioncode}")
	public BaseResListDto<SysDictRes> getDictList(@PathVariable String unioncode, @PathVariable Integer dictcode) {
		if(StringUtils.isEmpty(unioncode)) {
			return dictService.getDictList(WebContext.getUserSession().getUnioncode(), dictcode);
		}else {
			return dictService.getDictList(unioncode, dictcode);
		}
	}
	
	@RequestMapping("/gettype")
	public BaseResListDto<SysDictRes> getDictList(@RequestBody Map<String, String> req) {
		return dictService.getSpecialDict(req);
	}
	
	@RequestMapping("/getmap")
	public BaseResMapDto<String, List<SysDictRes>> getDictMap(String unioncode, String dictcode) {
		if(StringUtils.isEmpty(unioncode)) {
			unioncode = WebContext.getUserSession().getUnioncode();
		}
		return dictService.getDictMap(unioncode, dictcode);
	}

	@RequestMapping("/list")
	public BaseResListDto<SysDictRes> list(@RequestBody SysDictReq dictReq) {
		return dictService.pageSysDict(dictReq);
	}
}

package org.oversky.dreamland.controller.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComParamInfoReq;
import org.oversky.dreamland.dto.response.com.ComParamInfoRes;
import org.oversky.dreamland.service.com.ComParamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comparaminfo")
public class ComParamInfoController {
	@Autowired
	private ComParamInfoService comParamInfoService;

	@RequestMapping("/detail")
	public ComParamInfoRes detail(Integer paramid) {
		return comParamInfoService.getById(paramid);
	}

	@RequestMapping("/delete")
	public ComParamInfoRes delete(@RequestBody ComParamInfoReq request) {
		return comParamInfoService.delete(request);
	}

	@RequestMapping("/add")
	public ComParamInfoRes add(@RequestBody ComParamInfoReq request) {
		return comParamInfoService.insert(request);
	}

	@RequestMapping("/update")
	public ComParamInfoRes update(@RequestBody ComParamInfoReq request) {
		return comParamInfoService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ComParamInfoRes> page(@RequestBody ComParamInfoReq request) {
		return comParamInfoService.pageComParamInfo(request);
	}
}

package org.oversky.dreamland.controller.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComParamReq;
import org.oversky.dreamland.dto.response.com.ComParamInfoRes;
import org.oversky.dreamland.dto.response.com.ComParamRes;
import org.oversky.dreamland.service.com.ComParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comparam")
public class ComParamController {
	
	@Autowired
	private ComParamService paramService;

	@RequestMapping("/getlist")
	public BaseResListDto<ComParamRes> getList(String unioncode, String paramids) {
		return paramService.getParamList(unioncode, paramids);
	}
	
	@RequestMapping("/getparam/{paramid}/{unioncode}")
	public ComParamRes getParam(@PathVariable String unioncode, @PathVariable Integer paramid) {
		return paramService.getParam(unioncode, paramid);
	}

	@RequestMapping("/reset/{unioncode}")
	public ComParamRes reset(@PathVariable String unioncode) {
		return paramService.reset(unioncode);
	}

	@RequestMapping("/update")
	public ComParamRes update(@RequestBody ComParamReq paramReq) {
		return paramService.update(paramReq);
	}

	@RequestMapping("/page/{unioncode}")
	public BaseResListDto<ComParamInfoRes> paramPage(@PathVariable String unioncode) {
		return paramService.paramInfoPage(unioncode);
	}
}

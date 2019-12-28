package org.oversky.dreamland.controller.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustLogLoginReq;
import org.oversky.dreamland.dto.response.cust.CustLogLoginRes;
import org.oversky.dreamland.service.cust.CustLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custloglogin")
public class CustLogLoginController {
	@Autowired
	private CustLogLoginService custLogLoginService;

	@RequestMapping("/detail")
	public CustLogLoginRes detail(Long logid) {
		return custLogLoginService.getById(logid);
	}

	@RequestMapping("/delete")
	public CustLogLoginRes delete(@RequestBody CustLogLoginReq request) {
		return custLogLoginService.delete(request);
	}

	@RequestMapping("/add")
	public CustLogLoginRes add(@RequestBody CustLogLoginReq request) {
		return custLogLoginService.insert(request);
	}

	@RequestMapping("/update")
	public CustLogLoginRes update(@RequestBody CustLogLoginReq request) {
		return custLogLoginService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<CustLogLoginRes> page(@RequestBody CustLogLoginReq request) {
		return custLogLoginService.pageCustLogLogin(request);
	}
}

package org.oversky.dreamland.controller.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustLogTransReq;
import org.oversky.dreamland.dto.response.cust.CustLogTransRes;
import org.oversky.dreamland.service.cust.CustLogTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custlogtrans")
public class CustLogTransController {
	@Autowired
	private CustLogTransService custLogTransService;

	@RequestMapping("/detail")
	public CustLogTransRes detail(Long logid) {
		return custLogTransService.getById(logid);
	}

	@RequestMapping("/delete")
	public CustLogTransRes delete(@RequestBody CustLogTransReq request) {
		return custLogTransService.delete(request);
	}

	@RequestMapping("/add")
	public CustLogTransRes add(@RequestBody CustLogTransReq request) {
		return custLogTransService.insert(request);
	}

	@RequestMapping("/update")
	public CustLogTransRes update(@RequestBody CustLogTransReq request) {
		return custLogTransService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<CustLogTransRes> page(@RequestBody CustLogTransReq request) {
		return custLogTransService.pageCustLogTrans(request);
	}
}

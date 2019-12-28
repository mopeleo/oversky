package org.oversky.dreamland.controller.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustInfoExtReq;
import org.oversky.dreamland.dto.response.cust.CustInfoExtRes;
import org.oversky.dreamland.service.cust.CustInfoExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custinfoext")
public class CustInfoExtController {
	@Autowired
	private CustInfoExtService custInfoExtService;

	@RequestMapping("/detail")
	public CustInfoExtRes detail(Long custno) {
		return custInfoExtService.getById(custno);
	}

	@RequestMapping("/delete")
	public CustInfoExtRes delete(@RequestBody CustInfoExtReq request) {
		return custInfoExtService.delete(request);
	}

	@RequestMapping("/add")
	public CustInfoExtRes add(@RequestBody CustInfoExtReq request) {
		return custInfoExtService.insert(request);
	}

	@RequestMapping("/update")
	public CustInfoExtRes update(@RequestBody CustInfoExtReq request) {
		return custInfoExtService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<CustInfoExtRes> page(@RequestBody CustInfoExtReq request) {
		return custInfoExtService.pageCustInfoExt(request);
	}
}

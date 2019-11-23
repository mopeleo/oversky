package org.oversky.dreamland.cust.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;
import org.oversky.dreamland.service.cust.CustInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custinfo")
public class CustInfoController {
	@Autowired
	private CustInfoService custService;
	
	@RequestMapping("/detail")
	public CustInfoRes detail(Long custno) {
		return custService.custDetail(custno);
	}

	@RequestMapping("/add")
	public CustInfoRes add(@RequestBody CustInfoReq userReq) {
		return custService.insert(userReq);
	}

	@RequestMapping("/update")
	public CustInfoRes update(@RequestBody CustInfoReq userReq) {
		return custService.update(userReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<CustInfoRes> list(@RequestBody CustInfoReq userReq) {
		return custService.pageCustInfo(userReq);
	}

	@RequestMapping("/resetpassword")
	public CustInfoRes resetPassword(@RequestBody CustInfoReq userReq) {
		return custService.resetPassword(userReq);
	}

	@RequestMapping("/updatepassword")
	public CustInfoRes updatePassword(@RequestBody CustInfoReq userReq) {
		return custService.updatePassword(userReq);
	}

	@RequestMapping("/freeze")
	public CustInfoRes freeze(@RequestBody CustInfoReq userReq) {
		return custService.freeze(userReq);
	}

	@RequestMapping("/unfreeze")
	public CustInfoRes unfreeze(@RequestBody CustInfoReq userReq) {
		return custService.unfreeze(userReq);
	}

}

package org.oversky.dreamland.cust.service.impl;

import org.oversky.dreamland.cust.dto.request.CustInfoReq;
import org.oversky.dreamland.cust.dto.response.CustInfoRes;
import org.oversky.dreamland.cust.service.CustInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustInfoServiceImpl implements CustInfoService {
    private static Logger log = LoggerFactory.getLogger(CustInfoServiceImpl.class);

	@Override
	public CustInfoRes login(CustInfoReq req) {
		log.info("用户登录，req : {}", req.toString());
		CustInfoRes res = new CustInfoRes();
		res.success("登录成功");
		return res;
	}

}

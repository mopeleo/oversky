package org.oversky.dreamland.cust.service;

import org.oversky.dreamland.cust.dto.request.CustInfoReq;
import org.oversky.dreamland.cust.dto.response.CustInfoRes;

public interface CustInfoService {

	CustInfoRes login(CustInfoReq req);
}

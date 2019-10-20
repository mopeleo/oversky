package org.oversky.dreamland.service.cust;

import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;

public interface CustInfoService {

	CustInfoRes login(CustInfoReq req);
}

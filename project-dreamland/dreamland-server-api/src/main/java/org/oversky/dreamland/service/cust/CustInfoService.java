package org.oversky.dreamland.service.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;

public interface CustInfoService {

	CustInfoRes login(CustInfoReq req);
	
	CustInfoRes insert(CustInfoReq userReq);
	
	CustInfoRes update(CustInfoReq userReq);
	
	CustInfoRes custDetail(Long custno);

	CustInfoRes resetPassword(CustInfoReq req);
	
	CustInfoRes updatePassword(CustInfoReq req);
	
	CustInfoRes freeze(CustInfoReq userReq);
	
	CustInfoRes unfreeze(CustInfoReq userReq);
	
	BaseResListDto<CustInfoRes> pageCustInfo(CustInfoReq custReq);
}

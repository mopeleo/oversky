package org.oversky.dreamland.service.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;

public interface CustInfoService{

	CustInfoRes login(CustInfoReq req);
	
	CustInfoRes custDetail(Long custno);
	
	CustInfoRes insert(CustInfoReq req);
	
	CustInfoRes update(CustInfoReq req);

	CustInfoRes resetPassword(CustInfoReq custInfoReq);
	
	CustInfoRes updatePassword(CustInfoReq custInfoReq);
	
	CustInfoRes freeze(CustInfoReq custInfoReq);
	
	CustInfoRes unfreeze(CustInfoReq custInfoReq);
	
	BaseResListDto<CustInfoRes> pageCustInfo(CustInfoReq req);
}

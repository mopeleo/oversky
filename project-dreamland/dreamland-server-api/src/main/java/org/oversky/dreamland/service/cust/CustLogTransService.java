package org.oversky.dreamland.service.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustLogTransReq;
import org.oversky.dreamland.dto.response.cust.CustLogTransRes;

public interface CustLogTransService{

	CustLogTransRes getById(Long logid);
	
	CustLogTransRes delete(CustLogTransReq req);

	CustLogTransRes insert(CustLogTransReq req);
	
	CustLogTransRes update(CustLogTransReq req);

	BaseResListDto<CustLogTransRes> pageCustLogTrans(CustLogTransReq req);
}

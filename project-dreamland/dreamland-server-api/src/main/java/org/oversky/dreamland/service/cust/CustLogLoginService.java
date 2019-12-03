package org.oversky.dreamland.service.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustLogLoginReq;
import org.oversky.dreamland.dto.response.cust.CustLogLoginRes;

public interface CustLogLoginService{

	CustLogLoginRes getById(Long logid);
	
	CustLogLoginRes delete(CustLogLoginReq req);

	CustLogLoginRes insert(CustLogLoginReq req);
	
	CustLogLoginRes update(CustLogLoginReq req);

	BaseResListDto<CustLogLoginRes> pageCustLogLogin(CustLogLoginReq req);
}

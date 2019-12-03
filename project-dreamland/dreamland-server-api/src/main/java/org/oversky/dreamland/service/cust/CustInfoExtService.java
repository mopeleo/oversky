package org.oversky.dreamland.service.cust;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.cust.CustInfoExtReq;
import org.oversky.dreamland.dto.response.cust.CustInfoExtRes;

public interface CustInfoExtService{

	CustInfoExtRes getById(Long custno);
	
	CustInfoExtRes delete(CustInfoExtReq req);

	CustInfoExtRes insert(CustInfoExtReq req);
	
	CustInfoExtRes update(CustInfoExtReq req);

	BaseResListDto<CustInfoExtRes> pageCustInfoExt(CustInfoExtReq req);
}

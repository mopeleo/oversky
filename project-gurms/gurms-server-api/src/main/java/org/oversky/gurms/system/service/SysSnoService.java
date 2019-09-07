package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.request.SysSnoReq;
import org.oversky.gurms.system.dto.response.SysSnoRes;

public interface SysSnoService {

	SysSnoRes getById(String unioncode, Integer sno);
	
	SysSnoRes update(SysSnoReq snoReq);
	
	BaseResListDto<SysSnoRes> pageSysSno(SysSnoReq snoReq);
	
	String getNextSno(String unioncode, Integer snoid);
	
	String[] getBatchSno(String unioncode, Integer snoid, Integer number);

}

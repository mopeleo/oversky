package org.oversky.gurms.system.service;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dto.response.SysParamInfoRes;
import org.oversky.gurms.system.dto.response.SysParamRes;

public interface SysParamService {

	SysParamRes getParam(String unioncode, Integer paramId);
	
	BaseResListDto<SysParamRes> getParamList(String unioncode, String paramList);
	
	SysParamRes reset(String unioncode);

	SysParamRes update(String unioncode, String paramList);
	
	BaseResListDto<SysParamInfoRes> paramInfoList(String unioncode);
}

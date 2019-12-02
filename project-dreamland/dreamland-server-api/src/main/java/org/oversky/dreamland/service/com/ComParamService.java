package org.oversky.dreamland.service.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComParamReq;
import org.oversky.dreamland.dto.response.com.ComParamInfoRes;
import org.oversky.dreamland.dto.response.com.ComParamRes;

public interface ComParamService {

	ComParamRes getParam(String unioncode, Integer paramId);
	
	BaseResListDto<ComParamRes> getParamList(String unioncode, String paramList);
	
	ComParamRes update(ComParamReq paramReq);
	
	ComParamRes reset(String unioncode);
	
	BaseResListDto<ComParamInfoRes> paramInfoPage(String unioncode);
}

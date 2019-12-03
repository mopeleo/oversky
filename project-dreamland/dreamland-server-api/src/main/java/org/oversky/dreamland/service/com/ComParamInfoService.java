package org.oversky.dreamland.service.com;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.com.ComParamInfoReq;
import org.oversky.dreamland.dto.response.com.ComParamInfoRes;

public interface ComParamInfoService{

	ComParamInfoRes getById(Integer paramid);
	
	ComParamInfoRes delete(ComParamInfoReq req);

	ComParamInfoRes insert(ComParamInfoReq req);
	
	ComParamInfoRes update(ComParamInfoReq req);

	BaseResListDto<ComParamInfoRes> pageComParamInfo(ComParamInfoReq req);
}

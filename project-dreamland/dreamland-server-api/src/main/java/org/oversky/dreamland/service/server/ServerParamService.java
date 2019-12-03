package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerParamReq;
import org.oversky.dreamland.dto.response.server.ServerParamRes;

public interface ServerParamService{

	ServerParamRes getById(String serverid, String paramid);
	
	ServerParamRes delete(ServerParamReq req);

	ServerParamRes insert(ServerParamReq req);
	
	ServerParamRes update(ServerParamReq req);

	BaseResListDto<ServerParamRes> pageServerParam(ServerParamReq req);
}

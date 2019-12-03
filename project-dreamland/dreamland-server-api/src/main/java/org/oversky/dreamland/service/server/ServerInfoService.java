package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerInfoReq;
import org.oversky.dreamland.dto.response.server.ServerInfoRes;

public interface ServerInfoService{

	ServerInfoRes getById(String serverid);
	
	ServerInfoRes delete(ServerInfoReq req);

	ServerInfoRes insert(ServerInfoReq req);
	
	ServerInfoRes update(ServerInfoReq req);

	BaseResListDto<ServerInfoRes> pageServerInfo(ServerInfoReq req);
}

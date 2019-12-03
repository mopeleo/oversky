package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerRes;

public interface ServerPlayerService{

	ServerPlayerRes getById(String serverid, Long custno);
	
	ServerPlayerRes delete(ServerPlayerReq req);

	ServerPlayerRes insert(ServerPlayerReq req);
	
	ServerPlayerRes update(ServerPlayerReq req);

	BaseResListDto<ServerPlayerRes> pageServerPlayer(ServerPlayerReq req);
}

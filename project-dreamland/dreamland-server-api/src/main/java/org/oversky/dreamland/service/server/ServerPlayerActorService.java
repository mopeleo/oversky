package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorRes;

public interface ServerPlayerActorService{

	ServerPlayerActorRes getById(String serverid, Long custno, String actorid);
	
	ServerPlayerActorRes delete(ServerPlayerActorReq req);

	ServerPlayerActorRes insert(ServerPlayerActorReq req);
	
	ServerPlayerActorRes update(ServerPlayerActorReq req);

	BaseResListDto<ServerPlayerActorRes> pageServerPlayerActor(ServerPlayerActorReq req);
}

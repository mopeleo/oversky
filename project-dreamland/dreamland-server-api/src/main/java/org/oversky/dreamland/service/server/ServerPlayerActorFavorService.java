package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorFavorReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorFavorRes;

public interface ServerPlayerActorFavorService{

	ServerPlayerActorFavorRes getById(String serverid, String maleid, String femaleid);
	
	ServerPlayerActorFavorRes delete(ServerPlayerActorFavorReq req);

	ServerPlayerActorFavorRes insert(ServerPlayerActorFavorReq req);
	
	ServerPlayerActorFavorRes update(ServerPlayerActorFavorReq req);

	BaseResListDto<ServerPlayerActorFavorRes> pageServerPlayerActorFavor(ServerPlayerActorFavorReq req);
}

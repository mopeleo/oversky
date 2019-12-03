package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerLeagueReq;
import org.oversky.dreamland.dto.response.server.ServerLeagueRes;

public interface ServerLeagueService{

	ServerLeagueRes getById(Long leagueid);
	
	ServerLeagueRes delete(ServerLeagueReq req);

	ServerLeagueRes insert(ServerLeagueReq req);
	
	ServerLeagueRes update(ServerLeagueReq req);

	BaseResListDto<ServerLeagueRes> pageServerLeague(ServerLeagueReq req);
}

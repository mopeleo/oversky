package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerFriendReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerFriendRes;

public interface ServerPlayerFriendService{

	ServerPlayerFriendRes getById(String serverid);
	
	ServerPlayerFriendRes delete(ServerPlayerFriendReq req);

	ServerPlayerFriendRes insert(ServerPlayerFriendReq req);
	
	ServerPlayerFriendRes update(ServerPlayerFriendReq req);

	BaseResListDto<ServerPlayerFriendRes> pageServerPlayerFriend(ServerPlayerFriendReq req);
}

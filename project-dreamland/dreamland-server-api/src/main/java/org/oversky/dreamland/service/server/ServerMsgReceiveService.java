package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerMsgReceiveReq;
import org.oversky.dreamland.dto.response.server.ServerMsgReceiveRes;

public interface ServerMsgReceiveService{

	ServerMsgReceiveRes getById(Long msgid);
	
	ServerMsgReceiveRes delete(ServerMsgReceiveReq req);

	ServerMsgReceiveRes insert(ServerMsgReceiveReq req);
	
	ServerMsgReceiveRes update(ServerMsgReceiveReq req);

	BaseResListDto<ServerMsgReceiveRes> pageServerMsgReceive(ServerMsgReceiveReq req);
}

package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerMsgSendReq;
import org.oversky.dreamland.dto.response.server.ServerMsgSendRes;

public interface ServerMsgSendService{

	ServerMsgSendRes getById(Long msgid);
	
	ServerMsgSendRes delete(ServerMsgSendReq req);

	ServerMsgSendRes insert(ServerMsgSendReq req);
	
	ServerMsgSendRes update(ServerMsgSendReq req);

	BaseResListDto<ServerMsgSendRes> pageServerMsgSend(ServerMsgSendReq req);
}

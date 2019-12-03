package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerBulletinReq;
import org.oversky.dreamland.dto.response.server.ServerBulletinRes;

public interface ServerBulletinService{

	ServerBulletinRes getById(Long id);
	
	ServerBulletinRes delete(ServerBulletinReq req);

	ServerBulletinRes insert(ServerBulletinReq req);
	
	ServerBulletinRes update(ServerBulletinReq req);

	BaseResListDto<ServerBulletinRes> pageServerBulletin(ServerBulletinReq req);
}

package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerPackageReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerPackageRes;

public interface ServerPlayerPackageService{

	ServerPlayerPackageRes getById(String serverid, Long custno, Long itemid);
	
	ServerPlayerPackageRes delete(ServerPlayerPackageReq req);

	ServerPlayerPackageRes insert(ServerPlayerPackageReq req);
	
	ServerPlayerPackageRes update(ServerPlayerPackageReq req);

	BaseResListDto<ServerPlayerPackageRes> pageServerPlayerPackage(ServerPlayerPackageReq req);
}

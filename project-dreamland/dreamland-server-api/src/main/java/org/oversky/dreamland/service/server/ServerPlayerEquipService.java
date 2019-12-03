package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerEquipReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerEquipRes;

public interface ServerPlayerEquipService{

	ServerPlayerEquipRes getById(Long peid);
	
	ServerPlayerEquipRes delete(ServerPlayerEquipReq req);

	ServerPlayerEquipRes insert(ServerPlayerEquipReq req);
	
	ServerPlayerEquipRes update(ServerPlayerEquipReq req);

	BaseResListDto<ServerPlayerEquipRes> pageServerPlayerEquip(ServerPlayerEquipReq req);
}

package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerEquipAttributeReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerEquipAttributeRes;

public interface ServerPlayerEquipAttributeService{

	ServerPlayerEquipAttributeRes getById(Long peid, Long attrid);
	
	ServerPlayerEquipAttributeRes delete(ServerPlayerEquipAttributeReq req);

	ServerPlayerEquipAttributeRes insert(ServerPlayerEquipAttributeReq req);
	
	ServerPlayerEquipAttributeRes update(ServerPlayerEquipAttributeReq req);

	BaseResListDto<ServerPlayerEquipAttributeRes> pageServerPlayerEquipAttribute(ServerPlayerEquipAttributeReq req);
}

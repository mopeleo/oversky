package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorSkillReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorSkillRes;

public interface ServerPlayerActorSkillService{

	ServerPlayerActorSkillRes getById(Long paid, Long skillid);
	
	ServerPlayerActorSkillRes delete(ServerPlayerActorSkillReq req);

	ServerPlayerActorSkillRes insert(ServerPlayerActorSkillReq req);
	
	ServerPlayerActorSkillRes update(ServerPlayerActorSkillReq req);

	BaseResListDto<ServerPlayerActorSkillRes> pageServerPlayerActorSkill(ServerPlayerActorSkillReq req);
}

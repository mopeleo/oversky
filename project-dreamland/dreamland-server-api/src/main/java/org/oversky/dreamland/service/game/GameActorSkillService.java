package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameActorSkillReq;
import org.oversky.dreamland.dto.response.game.GameActorSkillRes;

public interface GameActorSkillService{

	GameActorSkillRes getById(Long actorid, Long skillid);
	
	GameActorSkillRes delete(GameActorSkillReq req);

	GameActorSkillRes insert(GameActorSkillReq req);
	
	GameActorSkillRes update(GameActorSkillReq req);

	BaseResListDto<GameActorSkillRes> pageGameActorSkill(GameActorSkillReq req);
}

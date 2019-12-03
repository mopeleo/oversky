package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSkillReq;
import org.oversky.dreamland.dto.response.game.GameSkillRes;

public interface GameSkillService{

	GameSkillRes getById(Long skillid);
	
	GameSkillRes delete(GameSkillReq req);

	GameSkillRes insert(GameSkillReq req);
	
	GameSkillRes update(GameSkillReq req);

	BaseResListDto<GameSkillRes> pageGameSkill(GameSkillReq req);
}

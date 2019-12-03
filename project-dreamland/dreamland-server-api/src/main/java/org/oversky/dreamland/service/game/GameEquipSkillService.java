package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipSkillReq;
import org.oversky.dreamland.dto.response.game.GameEquipSkillRes;

public interface GameEquipSkillService{

	GameEquipSkillRes getById(Long equipid, Long skillid);
	
	GameEquipSkillRes delete(GameEquipSkillReq req);

	GameEquipSkillRes insert(GameEquipSkillReq req);
	
	GameEquipSkillRes update(GameEquipSkillReq req);

	BaseResListDto<GameEquipSkillRes> pageGameEquipSkill(GameEquipSkillReq req);
}

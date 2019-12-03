package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSuitEquipReq;
import org.oversky.dreamland.dto.response.game.GameSuitEquipRes;

public interface GameSuitEquipService{

	GameSuitEquipRes getById(Long suitid, Long equipid);
	
	GameSuitEquipRes delete(GameSuitEquipReq req);

	GameSuitEquipRes insert(GameSuitEquipReq req);
	
	GameSuitEquipRes update(GameSuitEquipReq req);

	BaseResListDto<GameSuitEquipRes> pageGameSuitEquip(GameSuitEquipReq req);
}

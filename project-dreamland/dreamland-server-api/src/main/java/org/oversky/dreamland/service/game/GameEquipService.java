package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipReq;
import org.oversky.dreamland.dto.response.game.GameEquipRes;

public interface GameEquipService{

	GameEquipRes getById(Long equipid);
	
	GameEquipRes delete(GameEquipReq req);

	GameEquipRes insert(GameEquipReq req);
	
	GameEquipRes update(GameEquipReq req);

	BaseResListDto<GameEquipRes> pageGameEquip(GameEquipReq req);
}

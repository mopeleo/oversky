package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipReq;
import org.oversky.dreamland.dto.response.game.GameEquipRes;

public interface GameEquipService {

	GameEquipRes getById(Long gameid);
	
	GameEquipRes delete(GameEquipReq roleReq);

	GameEquipRes insert(GameEquipReq gameReq);
	
	GameEquipRes update(GameEquipReq gameReq);

	BaseResListDto<GameEquipRes> pageGameEquip(GameEquipReq gameReq);
}

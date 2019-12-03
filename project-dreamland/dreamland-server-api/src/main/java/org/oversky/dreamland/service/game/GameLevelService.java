package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameLevelReq;
import org.oversky.dreamland.dto.response.game.GameLevelRes;

public interface GameLevelService{

	GameLevelRes getById(Long levelid);
	
	GameLevelRes delete(GameLevelReq req);

	GameLevelRes insert(GameLevelReq req);
	
	GameLevelRes update(GameLevelReq req);

	BaseResListDto<GameLevelRes> pageGameLevel(GameLevelReq req);
}

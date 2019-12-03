package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSuitReq;
import org.oversky.dreamland.dto.response.game.GameSuitRes;

public interface GameSuitService{

	GameSuitRes getById(Long suitid);
	
	GameSuitRes delete(GameSuitReq req);

	GameSuitRes insert(GameSuitReq req);
	
	GameSuitRes update(GameSuitReq req);

	BaseResListDto<GameSuitRes> pageGameSuit(GameSuitReq req);
}

package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameMeunReq;
import org.oversky.dreamland.dto.response.game.GameMeunRes;

public interface GameMeunService{

	GameMeunRes getById(Long menuid);
	
	GameMeunRes delete(GameMeunReq req);

	GameMeunRes insert(GameMeunReq req);
	
	GameMeunRes update(GameMeunReq req);

	BaseResListDto<GameMeunRes> pageGameMeun(GameMeunReq req);
}

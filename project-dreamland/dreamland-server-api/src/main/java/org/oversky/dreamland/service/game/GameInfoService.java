package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameInfoReq;
import org.oversky.dreamland.dto.response.game.GameInfoRes;

public interface GameInfoService{

	GameInfoRes getById(Long gameid);
	
	GameInfoRes delete(GameInfoReq req);

	GameInfoRes insert(GameInfoReq req);
	
	GameInfoRes update(GameInfoReq req);

	BaseResListDto<GameInfoRes> pageGameInfo(GameInfoReq req);
}

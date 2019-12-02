package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameInfoReq;
import org.oversky.dreamland.dto.response.game.GameInfoRes;

public interface GameInfoService {

	GameInfoRes getById(Long gameid);
	
	GameInfoRes delete(GameInfoReq gameReq);

	GameInfoRes insert(GameInfoReq gameReq);
	
	GameInfoRes update(GameInfoReq gameReq);

	BaseResListDto<GameInfoRes> pageGameInfo(GameInfoReq gameReq);
}

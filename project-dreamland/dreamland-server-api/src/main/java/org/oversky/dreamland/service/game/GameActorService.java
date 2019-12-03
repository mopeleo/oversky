package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameActorReq;
import org.oversky.dreamland.dto.response.game.GameActorRes;

public interface GameActorService{

	GameActorRes getById(Long actorid);
	
	GameActorRes delete(GameActorReq req);

	GameActorRes insert(GameActorReq req);
	
	GameActorRes update(GameActorReq req);

	BaseResListDto<GameActorRes> pageGameActor(GameActorReq req);
}

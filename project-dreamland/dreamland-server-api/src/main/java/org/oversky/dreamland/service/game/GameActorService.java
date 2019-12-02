package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameActorReq;
import org.oversky.dreamland.dto.response.game.GameActorRes;

public interface GameActorService {

	GameActorRes getById(Long actorid);
	
	GameActorRes delete(GameActorReq gameActorReq);

	GameActorRes insert(GameActorReq gameActorReq);
	
	GameActorRes update(GameActorReq gameActorReq);

	BaseResListDto<GameActorRes> pageGameActor(GameActorReq gameActorReq);
}

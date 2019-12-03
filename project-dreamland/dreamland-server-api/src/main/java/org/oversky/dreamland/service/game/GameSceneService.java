package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSceneReq;
import org.oversky.dreamland.dto.response.game.GameSceneRes;

public interface GameSceneService{

	GameSceneRes getById(Long sceneid);
	
	GameSceneRes delete(GameSceneReq req);

	GameSceneRes insert(GameSceneReq req);
	
	GameSceneRes update(GameSceneReq req);

	BaseResListDto<GameSceneRes> pageGameScene(GameSceneReq req);
}

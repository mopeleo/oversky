package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSceneMenuReq;
import org.oversky.dreamland.dto.response.game.GameSceneMenuRes;

public interface GameSceneMenuService{

	GameSceneMenuRes getById(Long sceneid, Long menuid);
	
	GameSceneMenuRes delete(GameSceneMenuReq req);

	GameSceneMenuRes insert(GameSceneMenuReq req);
	
	GameSceneMenuRes update(GameSceneMenuReq req);

	BaseResListDto<GameSceneMenuRes> pageGameSceneMenu(GameSceneMenuReq req);
}

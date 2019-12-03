package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameItemReq;
import org.oversky.dreamland.dto.response.game.GameItemRes;

public interface GameItemService{

	GameItemRes getById(Long itemid);
	
	GameItemRes delete(GameItemReq req);

	GameItemRes insert(GameItemReq req);
	
	GameItemRes update(GameItemReq req);

	BaseResListDto<GameItemRes> pageGameItem(GameItemReq req);
}

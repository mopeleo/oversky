package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameAttributeReq;
import org.oversky.dreamland.dto.response.game.GameAttributeRes;

public interface GameAttributeService{

	GameAttributeRes getById(Long attrid);
	
	GameAttributeRes delete(GameAttributeReq req);

	GameAttributeRes insert(GameAttributeReq req);
	
	GameAttributeRes update(GameAttributeReq req);

	BaseResListDto<GameAttributeRes> pageGameAttribute(GameAttributeReq req);
}

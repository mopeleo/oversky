package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GamePromotionReq;
import org.oversky.dreamland.dto.response.game.GamePromotionRes;

public interface GamePromotionService{

	GamePromotionRes getById(Long promid);
	
	GamePromotionRes delete(GamePromotionReq req);

	GamePromotionRes insert(GamePromotionReq req);
	
	GamePromotionRes update(GamePromotionReq req);

	BaseResListDto<GamePromotionRes> pageGamePromotion(GamePromotionReq req);
}

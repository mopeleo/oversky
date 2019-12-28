package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GamePromotionReq;
import org.oversky.dreamland.dto.response.game.GamePromotionRes;
import org.oversky.dreamland.service.game.GamePromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamepromotion")
public class GamePromotionController {
	@Autowired
	private GamePromotionService gamePromotionService;

	@RequestMapping("/detail")
	public GamePromotionRes detail(Long promid) {
		return gamePromotionService.getById(promid);
	}

	@RequestMapping("/delete")
	public GamePromotionRes delete(@RequestBody GamePromotionReq request) {
		return gamePromotionService.delete(request);
	}

	@RequestMapping("/add")
	public GamePromotionRes add(@RequestBody GamePromotionReq request) {
		return gamePromotionService.insert(request);
	}

	@RequestMapping("/update")
	public GamePromotionRes update(@RequestBody GamePromotionReq request) {
		return gamePromotionService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GamePromotionRes> page(@RequestBody GamePromotionReq request) {
		return gamePromotionService.pageGamePromotion(request);
	}
}

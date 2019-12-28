package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameAttributeReq;
import org.oversky.dreamland.dto.response.game.GameAttributeRes;
import org.oversky.dreamland.service.game.GameAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameattribute")
public class GameAttributeController {
	@Autowired
	private GameAttributeService gameAttributeService;

	@RequestMapping("/detail")
	public GameAttributeRes detail(Long attrid) {
		return gameAttributeService.getById(attrid);
	}

	@RequestMapping("/delete")
	public GameAttributeRes delete(@RequestBody GameAttributeReq request) {
		return gameAttributeService.delete(request);
	}

	@RequestMapping("/add")
	public GameAttributeRes add(@RequestBody GameAttributeReq request) {
		return gameAttributeService.insert(request);
	}

	@RequestMapping("/update")
	public GameAttributeRes update(@RequestBody GameAttributeReq request) {
		return gameAttributeService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameAttributeRes> page(@RequestBody GameAttributeReq request) {
		return gameAttributeService.pageGameAttribute(request);
	}
}

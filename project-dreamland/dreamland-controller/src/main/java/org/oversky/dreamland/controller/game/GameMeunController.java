package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameMeunReq;
import org.oversky.dreamland.dto.response.game.GameMeunRes;
import org.oversky.dreamland.service.game.GameMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamemeun")
public class GameMeunController {
	@Autowired
	private GameMeunService gameMeunService;

	@RequestMapping("/detail")
	public GameMeunRes detail(Long menuid) {
		return gameMeunService.getById(menuid);
	}

	@RequestMapping("/delete")
	public GameMeunRes delete(@RequestBody GameMeunReq request) {
		return gameMeunService.delete(request);
	}

	@RequestMapping("/add")
	public GameMeunRes add(@RequestBody GameMeunReq request) {
		return gameMeunService.insert(request);
	}

	@RequestMapping("/update")
	public GameMeunRes update(@RequestBody GameMeunReq request) {
		return gameMeunService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameMeunRes> page(@RequestBody GameMeunReq request) {
		return gameMeunService.pageGameMeun(request);
	}
}

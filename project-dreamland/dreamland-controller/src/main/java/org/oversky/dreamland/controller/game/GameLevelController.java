package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameLevelReq;
import org.oversky.dreamland.dto.response.game.GameLevelRes;
import org.oversky.dreamland.service.game.GameLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamelevel")
public class GameLevelController {
	@Autowired
	private GameLevelService gameLevelService;

	@RequestMapping("/detail")
	public GameLevelRes detail(Long levelid) {
		return gameLevelService.getById(levelid);
	}

	@RequestMapping("/delete")
	public GameLevelRes delete(@RequestBody GameLevelReq request) {
		return gameLevelService.delete(request);
	}

	@RequestMapping("/add")
	public GameLevelRes add(@RequestBody GameLevelReq request) {
		return gameLevelService.insert(request);
	}

	@RequestMapping("/update")
	public GameLevelRes update(@RequestBody GameLevelReq request) {
		return gameLevelService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameLevelRes> page(@RequestBody GameLevelReq request) {
		return gameLevelService.pageGameLevel(request);
	}
}

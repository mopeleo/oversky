package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSceneReq;
import org.oversky.dreamland.dto.response.game.GameSceneRes;
import org.oversky.dreamland.service.game.GameSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamescene")
public class GameSceneController {
	@Autowired
	private GameSceneService gameSceneService;

	@RequestMapping("/detail")
	public GameSceneRes detail(Long sceneid) {
		return gameSceneService.getById(sceneid);
	}

	@RequestMapping("/delete")
	public GameSceneRes delete(@RequestBody GameSceneReq request) {
		return gameSceneService.delete(request);
	}

	@RequestMapping("/add")
	public GameSceneRes add(@RequestBody GameSceneReq request) {
		return gameSceneService.insert(request);
	}

	@RequestMapping("/update")
	public GameSceneRes update(@RequestBody GameSceneReq request) {
		return gameSceneService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameSceneRes> page(@RequestBody GameSceneReq request) {
		return gameSceneService.pageGameScene(request);
	}
}

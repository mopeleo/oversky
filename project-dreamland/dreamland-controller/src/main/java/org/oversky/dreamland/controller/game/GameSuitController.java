package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSuitReq;
import org.oversky.dreamland.dto.response.game.GameSuitRes;
import org.oversky.dreamland.service.game.GameSuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamesuit")
public class GameSuitController {
	@Autowired
	private GameSuitService gameSuitService;

	@RequestMapping("/detail")
	public GameSuitRes detail(Long suitid) {
		return gameSuitService.getById(suitid);
	}

	@RequestMapping("/delete")
	public GameSuitRes delete(@RequestBody GameSuitReq request) {
		return gameSuitService.delete(request);
	}

	@RequestMapping("/add")
	public GameSuitRes add(@RequestBody GameSuitReq request) {
		return gameSuitService.insert(request);
	}

	@RequestMapping("/update")
	public GameSuitRes update(@RequestBody GameSuitReq request) {
		return gameSuitService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameSuitRes> page(@RequestBody GameSuitReq request) {
		return gameSuitService.pageGameSuit(request);
	}
}

package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameInfoReq;
import org.oversky.dreamland.dto.response.game.GameInfoRes;
import org.oversky.dreamland.service.game.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameinfo")
public class GameInfoController {
	@Autowired
	private GameInfoService gameInfoService;

	@RequestMapping("/detail")
	public GameInfoRes detail(Long gameid) {
		return gameInfoService.getById(gameid);
	}

	@RequestMapping("/delete")
	public GameInfoRes delete(@RequestBody GameInfoReq gameReq) {
		return gameInfoService.delete(gameReq);
	}

	@RequestMapping("/add")
	public GameInfoRes add(@RequestBody GameInfoReq gameReq) {
		return gameInfoService.insert(gameReq);
	}

	@RequestMapping("/update")
	public GameInfoRes update(@RequestBody GameInfoReq gameReq) {
		return gameInfoService.update(gameReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<GameInfoRes> list(@RequestBody GameInfoReq gameReq) {
		return gameInfoService.pageGameInfo(gameReq);
	}


}

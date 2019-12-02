package org.oversky.dreamland.game.controller;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameActorReq;
import org.oversky.dreamland.dto.response.game.GameActorRes;
import org.oversky.dreamland.service.game.GameActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameactor")
public class GameActorController {
	@Autowired
	private GameActorService gameActorService;

	@RequestMapping("/detail")
	public GameActorRes detail(Long gameid) {
		return gameActorService.getById(gameid);
	}

	@RequestMapping("/delete")
	public GameActorRes delete(@RequestBody GameActorReq gameReq) {
		return gameActorService.delete(gameReq);
	}

	@RequestMapping("/add")
	public GameActorRes add(@RequestBody GameActorReq gameReq) {
		return gameActorService.insert(gameReq);
	}

	@RequestMapping("/update")
	public GameActorRes update(@RequestBody GameActorReq gameReq) {
		return gameActorService.update(gameReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<GameActorRes> list(@RequestBody GameActorReq gameReq) {
		return gameActorService.pageGameActor(gameReq);
	}


}

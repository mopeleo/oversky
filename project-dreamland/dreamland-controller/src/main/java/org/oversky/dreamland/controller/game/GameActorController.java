package org.oversky.dreamland.controller.game;

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
	public GameActorRes detail(Long actorid) {
		return gameActorService.getById(actorid);
	}

	@RequestMapping("/delete")
	public GameActorRes delete(@RequestBody GameActorReq gameActorReq) {
		return gameActorService.delete(gameActorReq);
	}

	@RequestMapping("/add")
	public GameActorRes add(@RequestBody GameActorReq gameActorReq) {
		return gameActorService.insert(gameActorReq);
	}

	@RequestMapping("/update")
	public GameActorRes update(@RequestBody GameActorReq gameActorReq) {
		return gameActorService.update(gameActorReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<GameActorRes> list(@RequestBody GameActorReq gameActorReq) {
		return gameActorService.pageGameActor(gameActorReq);
	}


}

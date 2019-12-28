package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameActorSkillReq;
import org.oversky.dreamland.dto.response.game.GameActorSkillRes;
import org.oversky.dreamland.service.game.GameActorSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameactorskill")
public class GameActorSkillController {
	@Autowired
	private GameActorSkillService gameActorSkillService;

	@RequestMapping("/detail")
	public GameActorSkillRes detail(Long actorid, Long skillid) {
		return gameActorSkillService.getById(actorid, skillid);
	}

	@RequestMapping("/delete")
	public GameActorSkillRes delete(@RequestBody GameActorSkillReq request) {
		return gameActorSkillService.delete(request);
	}

	@RequestMapping("/add")
	public GameActorSkillRes add(@RequestBody GameActorSkillReq request) {
		return gameActorSkillService.insert(request);
	}

	@RequestMapping("/update")
	public GameActorSkillRes update(@RequestBody GameActorSkillReq request) {
		return gameActorSkillService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameActorSkillRes> page(@RequestBody GameActorSkillReq request) {
		return gameActorSkillService.pageGameActorSkill(request);
	}
}

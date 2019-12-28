package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSkillReq;
import org.oversky.dreamland.dto.response.game.GameSkillRes;
import org.oversky.dreamland.service.game.GameSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameskill")
public class GameSkillController {
	@Autowired
	private GameSkillService gameSkillService;

	@RequestMapping("/detail")
	public GameSkillRes detail(Long skillid) {
		return gameSkillService.getById(skillid);
	}

	@RequestMapping("/delete")
	public GameSkillRes delete(@RequestBody GameSkillReq request) {
		return gameSkillService.delete(request);
	}

	@RequestMapping("/add")
	public GameSkillRes add(@RequestBody GameSkillReq request) {
		return gameSkillService.insert(request);
	}

	@RequestMapping("/update")
	public GameSkillRes update(@RequestBody GameSkillReq request) {
		return gameSkillService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameSkillRes> page(@RequestBody GameSkillReq request) {
		return gameSkillService.pageGameSkill(request);
	}
}

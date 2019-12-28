package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipSkillReq;
import org.oversky.dreamland.dto.response.game.GameEquipSkillRes;
import org.oversky.dreamland.service.game.GameEquipSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameequipskill")
public class GameEquipSkillController {
	@Autowired
	private GameEquipSkillService gameEquipSkillService;

	@RequestMapping("/detail")
	public GameEquipSkillRes detail(Long equipid, Long skillid) {
		return gameEquipSkillService.getById(equipid, skillid);
	}

	@RequestMapping("/delete")
	public GameEquipSkillRes delete(@RequestBody GameEquipSkillReq request) {
		return gameEquipSkillService.delete(request);
	}

	@RequestMapping("/add")
	public GameEquipSkillRes add(@RequestBody GameEquipSkillReq request) {
		return gameEquipSkillService.insert(request);
	}

	@RequestMapping("/update")
	public GameEquipSkillRes update(@RequestBody GameEquipSkillReq request) {
		return gameEquipSkillService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameEquipSkillRes> page(@RequestBody GameEquipSkillReq request) {
		return gameEquipSkillService.pageGameEquipSkill(request);
	}
}

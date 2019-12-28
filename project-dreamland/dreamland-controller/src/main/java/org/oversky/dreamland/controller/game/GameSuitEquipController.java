package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameSuitEquipReq;
import org.oversky.dreamland.dto.response.game.GameSuitEquipRes;
import org.oversky.dreamland.service.game.GameSuitEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamesuitequip")
public class GameSuitEquipController {
	@Autowired
	private GameSuitEquipService gameSuitEquipService;

	@RequestMapping("/detail")
	public GameSuitEquipRes detail(Long suitid, Long equipid) {
		return gameSuitEquipService.getById(suitid, equipid);
	}

	@RequestMapping("/delete")
	public GameSuitEquipRes delete(@RequestBody GameSuitEquipReq request) {
		return gameSuitEquipService.delete(request);
	}

	@RequestMapping("/add")
	public GameSuitEquipRes add(@RequestBody GameSuitEquipReq request) {
		return gameSuitEquipService.insert(request);
	}

	@RequestMapping("/update")
	public GameSuitEquipRes update(@RequestBody GameSuitEquipReq request) {
		return gameSuitEquipService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameSuitEquipRes> page(@RequestBody GameSuitEquipReq request) {
		return gameSuitEquipService.pageGameSuitEquip(request);
	}
}

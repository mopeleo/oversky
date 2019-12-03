package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipReq;
import org.oversky.dreamland.dto.response.game.GameEquipRes;
import org.oversky.dreamland.service.game.GameEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameequip")
public class GameEquipController {
	@Autowired
	private GameEquipService gameInfoService;

	@RequestMapping("/detail")
	public GameEquipRes detail(Long gameid) {
		return gameInfoService.getById(gameid);
	}

	@RequestMapping("/delete")
	public GameEquipRes delete(@RequestBody GameEquipReq gameReq) {
		return gameInfoService.delete(gameReq);
	}

	@RequestMapping("/add")
	public GameEquipRes add(@RequestBody GameEquipReq gameReq) {
		return gameInfoService.insert(gameReq);
	}

	@RequestMapping("/update")
	public GameEquipRes update(@RequestBody GameEquipReq gameReq) {
		return gameInfoService.update(gameReq);
	}

	@RequestMapping("/list")
	public BaseResListDto<GameEquipRes> list(@RequestBody GameEquipReq gameReq) {
		return gameInfoService.pageGameEquip(gameReq);
	}


}

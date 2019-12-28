package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameItemReq;
import org.oversky.dreamland.dto.response.game.GameItemRes;
import org.oversky.dreamland.service.game.GameItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameitem")
public class GameItemController {
	@Autowired
	private GameItemService gameItemService;

	@RequestMapping("/detail")
	public GameItemRes detail(Long itemid) {
		return gameItemService.getById(itemid);
	}

	@RequestMapping("/delete")
	public GameItemRes delete(@RequestBody GameItemReq request) {
		return gameItemService.delete(request);
	}

	@RequestMapping("/add")
	public GameItemRes add(@RequestBody GameItemReq request) {
		return gameItemService.insert(request);
	}

	@RequestMapping("/update")
	public GameItemRes update(@RequestBody GameItemReq request) {
		return gameItemService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameItemRes> page(@RequestBody GameItemReq request) {
		return gameItemService.pageGameItem(request);
	}
}

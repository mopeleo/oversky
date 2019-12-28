package org.oversky.dreamland.controller.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameChannelReq;
import org.oversky.dreamland.dto.response.game.GameChannelRes;
import org.oversky.dreamland.service.game.GameChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamechannel")
public class GameChannelController {
	@Autowired
	private GameChannelService gameChannelService;

	@RequestMapping("/detail")
	public GameChannelRes detail(Integer channelid) {
		return gameChannelService.getById(channelid);
	}

	@RequestMapping("/delete")
	public GameChannelRes delete(@RequestBody GameChannelReq request) {
		return gameChannelService.delete(request);
	}

	@RequestMapping("/add")
	public GameChannelRes add(@RequestBody GameChannelReq request) {
		return gameChannelService.insert(request);
	}

	@RequestMapping("/update")
	public GameChannelRes update(@RequestBody GameChannelReq request) {
		return gameChannelService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<GameChannelRes> page(@RequestBody GameChannelReq request) {
		return gameChannelService.pageGameChannel(request);
	}
}

package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerRes;
import org.oversky.dreamland.service.server.ServerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayer")
public class ServerPlayerController {
	@Autowired
	private ServerPlayerService serverPlayerService;

	@RequestMapping("/detail")
	public ServerPlayerRes detail(String serverid, Long custno) {
		return serverPlayerService.getById(serverid, custno);
	}

	@RequestMapping("/delete")
	public ServerPlayerRes delete(@RequestBody ServerPlayerReq request) {
		return serverPlayerService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerRes add(@RequestBody ServerPlayerReq request) {
		return serverPlayerService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerRes update(@RequestBody ServerPlayerReq request) {
		return serverPlayerService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerRes> page(@RequestBody ServerPlayerReq request) {
		return serverPlayerService.pageServerPlayer(request);
	}
}

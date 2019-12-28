package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorFavorReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorFavorRes;
import org.oversky.dreamland.service.server.ServerPlayerActorFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayeractorfavor")
public class ServerPlayerActorFavorController {
	@Autowired
	private ServerPlayerActorFavorService serverPlayerActorFavorService;

	@RequestMapping("/detail")
	public ServerPlayerActorFavorRes detail(String serverid, String maleid, String femaleid) {
		return serverPlayerActorFavorService.getById(serverid, maleid, femaleid);
	}

	@RequestMapping("/delete")
	public ServerPlayerActorFavorRes delete(@RequestBody ServerPlayerActorFavorReq request) {
		return serverPlayerActorFavorService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerActorFavorRes add(@RequestBody ServerPlayerActorFavorReq request) {
		return serverPlayerActorFavorService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerActorFavorRes update(@RequestBody ServerPlayerActorFavorReq request) {
		return serverPlayerActorFavorService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerActorFavorRes> page(@RequestBody ServerPlayerActorFavorReq request) {
		return serverPlayerActorFavorService.pageServerPlayerActorFavor(request);
	}
}

package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorRes;
import org.oversky.dreamland.service.server.ServerPlayerActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayeractor")
public class ServerPlayerActorController {
	@Autowired
	private ServerPlayerActorService serverPlayerActorService;

	@RequestMapping("/detail")
	public ServerPlayerActorRes detail(String serverid, Long custno, String actorid) {
		return serverPlayerActorService.getById(serverid, custno, actorid);
	}

	@RequestMapping("/delete")
	public ServerPlayerActorRes delete(@RequestBody ServerPlayerActorReq request) {
		return serverPlayerActorService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerActorRes add(@RequestBody ServerPlayerActorReq request) {
		return serverPlayerActorService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerActorRes update(@RequestBody ServerPlayerActorReq request) {
		return serverPlayerActorService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerActorRes> page(@RequestBody ServerPlayerActorReq request) {
		return serverPlayerActorService.pageServerPlayerActor(request);
	}
}

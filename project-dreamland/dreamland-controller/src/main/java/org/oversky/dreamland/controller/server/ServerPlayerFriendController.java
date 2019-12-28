package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerFriendReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerFriendRes;
import org.oversky.dreamland.service.server.ServerPlayerFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayerfriend")
public class ServerPlayerFriendController {
	@Autowired
	private ServerPlayerFriendService serverPlayerFriendService;

	@RequestMapping("/detail")
	public ServerPlayerFriendRes detail(String serverid) {
		return serverPlayerFriendService.getById(serverid);
	}

	@RequestMapping("/delete")
	public ServerPlayerFriendRes delete(@RequestBody ServerPlayerFriendReq request) {
		return serverPlayerFriendService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerFriendRes add(@RequestBody ServerPlayerFriendReq request) {
		return serverPlayerFriendService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerFriendRes update(@RequestBody ServerPlayerFriendReq request) {
		return serverPlayerFriendService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerFriendRes> page(@RequestBody ServerPlayerFriendReq request) {
		return serverPlayerFriendService.pageServerPlayerFriend(request);
	}
}

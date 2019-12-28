package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerMsgReceiveReq;
import org.oversky.dreamland.dto.response.server.ServerMsgReceiveRes;
import org.oversky.dreamland.service.server.ServerMsgReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servermsgreceive")
public class ServerMsgReceiveController {
	@Autowired
	private ServerMsgReceiveService serverMsgReceiveService;

	@RequestMapping("/detail")
	public ServerMsgReceiveRes detail(Long msgid) {
		return serverMsgReceiveService.getById(msgid);
	}

	@RequestMapping("/delete")
	public ServerMsgReceiveRes delete(@RequestBody ServerMsgReceiveReq request) {
		return serverMsgReceiveService.delete(request);
	}

	@RequestMapping("/add")
	public ServerMsgReceiveRes add(@RequestBody ServerMsgReceiveReq request) {
		return serverMsgReceiveService.insert(request);
	}

	@RequestMapping("/update")
	public ServerMsgReceiveRes update(@RequestBody ServerMsgReceiveReq request) {
		return serverMsgReceiveService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerMsgReceiveRes> page(@RequestBody ServerMsgReceiveReq request) {
		return serverMsgReceiveService.pageServerMsgReceive(request);
	}
}

package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerMsgSendReq;
import org.oversky.dreamland.dto.response.server.ServerMsgSendRes;
import org.oversky.dreamland.service.server.ServerMsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servermsgsend")
public class ServerMsgSendController {
	@Autowired
	private ServerMsgSendService serverMsgSendService;

	@RequestMapping("/detail")
	public ServerMsgSendRes detail(Long msgid) {
		return serverMsgSendService.getById(msgid);
	}

	@RequestMapping("/delete")
	public ServerMsgSendRes delete(@RequestBody ServerMsgSendReq request) {
		return serverMsgSendService.delete(request);
	}

	@RequestMapping("/add")
	public ServerMsgSendRes add(@RequestBody ServerMsgSendReq request) {
		return serverMsgSendService.insert(request);
	}

	@RequestMapping("/update")
	public ServerMsgSendRes update(@RequestBody ServerMsgSendReq request) {
		return serverMsgSendService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerMsgSendRes> page(@RequestBody ServerMsgSendReq request) {
		return serverMsgSendService.pageServerMsgSend(request);
	}
}

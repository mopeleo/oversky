package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerInfoReq;
import org.oversky.dreamland.dto.response.server.ServerInfoRes;
import org.oversky.dreamland.service.server.ServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverinfo")
public class ServerInfoController {
	@Autowired
	private ServerInfoService serverInfoService;

	@RequestMapping("/detail")
	public ServerInfoRes detail(String serverid) {
		return serverInfoService.getById(serverid);
	}

	@RequestMapping("/delete")
	public ServerInfoRes delete(@RequestBody ServerInfoReq request) {
		return serverInfoService.delete(request);
	}

	@RequestMapping("/add")
	public ServerInfoRes add(@RequestBody ServerInfoReq request) {
		return serverInfoService.insert(request);
	}

	@RequestMapping("/update")
	public ServerInfoRes update(@RequestBody ServerInfoReq request) {
		return serverInfoService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerInfoRes> page(@RequestBody ServerInfoReq request) {
		return serverInfoService.pageServerInfo(request);
	}
}

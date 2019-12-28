package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerParamReq;
import org.oversky.dreamland.dto.response.server.ServerParamRes;
import org.oversky.dreamland.service.server.ServerParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverparam")
public class ServerParamController {
	@Autowired
	private ServerParamService serverParamService;

	@RequestMapping("/detail")
	public ServerParamRes detail(String serverid, String paramid) {
		return serverParamService.getById(serverid, paramid);
	}

	@RequestMapping("/delete")
	public ServerParamRes delete(@RequestBody ServerParamReq request) {
		return serverParamService.delete(request);
	}

	@RequestMapping("/add")
	public ServerParamRes add(@RequestBody ServerParamReq request) {
		return serverParamService.insert(request);
	}

	@RequestMapping("/update")
	public ServerParamRes update(@RequestBody ServerParamReq request) {
		return serverParamService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerParamRes> page(@RequestBody ServerParamReq request) {
		return serverParamService.pageServerParam(request);
	}
}

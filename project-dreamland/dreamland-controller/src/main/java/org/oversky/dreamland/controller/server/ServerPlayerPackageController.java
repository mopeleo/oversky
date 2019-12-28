package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerPackageReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerPackageRes;
import org.oversky.dreamland.service.server.ServerPlayerPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayerpackage")
public class ServerPlayerPackageController {
	@Autowired
	private ServerPlayerPackageService serverPlayerPackageService;

	@RequestMapping("/detail")
	public ServerPlayerPackageRes detail(String serverid, Long custno, Long itemid) {
		return serverPlayerPackageService.getById(serverid, custno, itemid);
	}

	@RequestMapping("/delete")
	public ServerPlayerPackageRes delete(@RequestBody ServerPlayerPackageReq request) {
		return serverPlayerPackageService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerPackageRes add(@RequestBody ServerPlayerPackageReq request) {
		return serverPlayerPackageService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerPackageRes update(@RequestBody ServerPlayerPackageReq request) {
		return serverPlayerPackageService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerPackageRes> page(@RequestBody ServerPlayerPackageReq request) {
		return serverPlayerPackageService.pageServerPlayerPackage(request);
	}
}

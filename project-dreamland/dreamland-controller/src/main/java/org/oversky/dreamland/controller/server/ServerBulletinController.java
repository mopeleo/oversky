package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerBulletinReq;
import org.oversky.dreamland.dto.response.server.ServerBulletinRes;
import org.oversky.dreamland.service.server.ServerBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverbulletin")
public class ServerBulletinController {
	@Autowired
	private ServerBulletinService serverBulletinService;

	@RequestMapping("/detail")
	public ServerBulletinRes detail(Long id) {
		return serverBulletinService.getById(id);
	}

	@RequestMapping("/delete")
	public ServerBulletinRes delete(@RequestBody ServerBulletinReq request) {
		return serverBulletinService.delete(request);
	}

	@RequestMapping("/add")
	public ServerBulletinRes add(@RequestBody ServerBulletinReq request) {
		return serverBulletinService.insert(request);
	}

	@RequestMapping("/update")
	public ServerBulletinRes update(@RequestBody ServerBulletinReq request) {
		return serverBulletinService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerBulletinRes> page(@RequestBody ServerBulletinReq request) {
		return serverBulletinService.pageServerBulletin(request);
	}
}

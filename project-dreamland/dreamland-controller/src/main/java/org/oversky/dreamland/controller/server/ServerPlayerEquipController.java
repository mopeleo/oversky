package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerEquipReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerEquipRes;
import org.oversky.dreamland.service.server.ServerPlayerEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayerequip")
public class ServerPlayerEquipController {
	@Autowired
	private ServerPlayerEquipService serverPlayerEquipService;

	@RequestMapping("/detail")
	public ServerPlayerEquipRes detail(Long peid) {
		return serverPlayerEquipService.getById(peid);
	}

	@RequestMapping("/delete")
	public ServerPlayerEquipRes delete(@RequestBody ServerPlayerEquipReq request) {
		return serverPlayerEquipService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerEquipRes add(@RequestBody ServerPlayerEquipReq request) {
		return serverPlayerEquipService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerEquipRes update(@RequestBody ServerPlayerEquipReq request) {
		return serverPlayerEquipService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerEquipRes> page(@RequestBody ServerPlayerEquipReq request) {
		return serverPlayerEquipService.pageServerPlayerEquip(request);
	}
}

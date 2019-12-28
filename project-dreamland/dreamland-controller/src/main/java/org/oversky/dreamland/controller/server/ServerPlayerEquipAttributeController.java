package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerEquipAttributeReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerEquipAttributeRes;
import org.oversky.dreamland.service.server.ServerPlayerEquipAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayerequipattribute")
public class ServerPlayerEquipAttributeController {
	@Autowired
	private ServerPlayerEquipAttributeService serverPlayerEquipAttributeService;

	@RequestMapping("/detail")
	public ServerPlayerEquipAttributeRes detail(Long peid, Long attrid) {
		return serverPlayerEquipAttributeService.getById(peid, attrid);
	}

	@RequestMapping("/delete")
	public ServerPlayerEquipAttributeRes delete(@RequestBody ServerPlayerEquipAttributeReq request) {
		return serverPlayerEquipAttributeService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerEquipAttributeRes add(@RequestBody ServerPlayerEquipAttributeReq request) {
		return serverPlayerEquipAttributeService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerEquipAttributeRes update(@RequestBody ServerPlayerEquipAttributeReq request) {
		return serverPlayerEquipAttributeService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerEquipAttributeRes> page(@RequestBody ServerPlayerEquipAttributeReq request) {
		return serverPlayerEquipAttributeService.pageServerPlayerEquipAttribute(request);
	}
}

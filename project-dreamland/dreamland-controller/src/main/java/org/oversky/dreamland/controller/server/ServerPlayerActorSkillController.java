package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPlayerActorSkillReq;
import org.oversky.dreamland.dto.response.server.ServerPlayerActorSkillRes;
import org.oversky.dreamland.service.server.ServerPlayerActorSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverplayeractorskill")
public class ServerPlayerActorSkillController {
	@Autowired
	private ServerPlayerActorSkillService serverPlayerActorSkillService;

	@RequestMapping("/detail")
	public ServerPlayerActorSkillRes detail(Long paid, Long skillid) {
		return serverPlayerActorSkillService.getById(paid, skillid);
	}

	@RequestMapping("/delete")
	public ServerPlayerActorSkillRes delete(@RequestBody ServerPlayerActorSkillReq request) {
		return serverPlayerActorSkillService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPlayerActorSkillRes add(@RequestBody ServerPlayerActorSkillReq request) {
		return serverPlayerActorSkillService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPlayerActorSkillRes update(@RequestBody ServerPlayerActorSkillReq request) {
		return serverPlayerActorSkillService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPlayerActorSkillRes> page(@RequestBody ServerPlayerActorSkillReq request) {
		return serverPlayerActorSkillService.pageServerPlayerActorSkill(request);
	}
}

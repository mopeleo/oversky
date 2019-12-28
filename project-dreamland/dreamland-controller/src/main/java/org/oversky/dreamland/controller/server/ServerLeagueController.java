package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerLeagueReq;
import org.oversky.dreamland.dto.response.server.ServerLeagueRes;
import org.oversky.dreamland.service.server.ServerLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverleague")
public class ServerLeagueController {
	@Autowired
	private ServerLeagueService serverLeagueService;

	@RequestMapping("/detail")
	public ServerLeagueRes detail(Long leagueid) {
		return serverLeagueService.getById(leagueid);
	}

	@RequestMapping("/delete")
	public ServerLeagueRes delete(@RequestBody ServerLeagueReq request) {
		return serverLeagueService.delete(request);
	}

	@RequestMapping("/add")
	public ServerLeagueRes add(@RequestBody ServerLeagueReq request) {
		return serverLeagueService.insert(request);
	}

	@RequestMapping("/update")
	public ServerLeagueRes update(@RequestBody ServerLeagueReq request) {
		return serverLeagueService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerLeagueRes> page(@RequestBody ServerLeagueReq request) {
		return serverLeagueService.pageServerLeague(request);
	}
}

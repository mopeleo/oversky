package org.oversky.dreamland.controller.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPromotionReq;
import org.oversky.dreamland.dto.response.server.ServerPromotionRes;
import org.oversky.dreamland.service.server.ServerPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serverpromotion")
public class ServerPromotionController {
	@Autowired
	private ServerPromotionService serverPromotionService;

	@RequestMapping("/detail")
	public ServerPromotionRes detail(String serverid, Long promid) {
		return serverPromotionService.getById(serverid, promid);
	}

	@RequestMapping("/delete")
	public ServerPromotionRes delete(@RequestBody ServerPromotionReq request) {
		return serverPromotionService.delete(request);
	}

	@RequestMapping("/add")
	public ServerPromotionRes add(@RequestBody ServerPromotionReq request) {
		return serverPromotionService.insert(request);
	}

	@RequestMapping("/update")
	public ServerPromotionRes update(@RequestBody ServerPromotionReq request) {
		return serverPromotionService.update(request);
	}

	@RequestMapping("/page")
	public BaseResListDto<ServerPromotionRes> page(@RequestBody ServerPromotionReq request) {
		return serverPromotionService.pageServerPromotion(request);
	}
}

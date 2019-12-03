package org.oversky.dreamland.service.server;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.server.ServerPromotionReq;
import org.oversky.dreamland.dto.response.server.ServerPromotionRes;

public interface ServerPromotionService{

	ServerPromotionRes getById(String serverid, Long promid);
	
	ServerPromotionRes delete(ServerPromotionReq req);

	ServerPromotionRes insert(ServerPromotionReq req);
	
	ServerPromotionRes update(ServerPromotionReq req);

	BaseResListDto<ServerPromotionRes> pageServerPromotion(ServerPromotionReq req);
}

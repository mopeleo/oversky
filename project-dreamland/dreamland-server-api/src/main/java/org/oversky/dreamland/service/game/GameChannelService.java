package org.oversky.dreamland.service.game;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameChannelReq;
import org.oversky.dreamland.dto.response.game.GameChannelRes;

public interface GameChannelService{

	GameChannelRes getById(Integer channelid);
	
	GameChannelRes delete(GameChannelReq req);

	GameChannelRes insert(GameChannelReq req);
	
	GameChannelRes update(GameChannelReq req);

	BaseResListDto<GameChannelRes> pageGameChannel(GameChannelReq req);
}

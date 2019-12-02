package org.oversky.dreamland.service.game.impl;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dto.request.game.GameEquipReq;
import org.oversky.dreamland.dto.response.game.GameEquipRes;
import org.oversky.dreamland.service.game.GameEquipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameEquipServiceImpl implements GameEquipService {
    private static Logger log = LoggerFactory.getLogger(GameEquipServiceImpl.class);

	@Override
	public GameEquipRes getById(Long gameid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameEquipRes delete(GameEquipReq roleReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameEquipRes insert(GameEquipReq gameReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameEquipRes update(GameEquipReq gameReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResListDto<GameEquipRes> pageGameEquip(GameEquipReq gameReq) {
		// TODO Auto-generated method stub
		return null;
	}

}

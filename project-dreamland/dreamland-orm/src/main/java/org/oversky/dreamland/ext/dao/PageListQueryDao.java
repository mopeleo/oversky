package org.oversky.dreamland.ext.dao;

import java.util.List;

import org.oversky.dreamland.entity.com.ComParamInfo;
import org.oversky.dreamland.entity.cust.CustInfo;
import org.oversky.dreamland.entity.game.GameActor;
import org.oversky.dreamland.entity.game.GameEquip;
import org.oversky.dreamland.entity.game.GameInfo;

public interface PageListQueryDao {

	List<ComParamInfo> findParams(String unioncode);

	List<CustInfo> findCustList(CustInfo where);
	
	List<GameInfo> findGameList(GameInfo where);
	
	List<GameActor> findGameActorList(GameActor where);
	
	List<GameEquip> findGameEquipList(GameEquip where);
	
}

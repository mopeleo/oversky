package org.oversky.dreamland.ext.dao;

import java.util.List;

import org.oversky.dreamland.entity.cust.CustInfo;
import org.oversky.dreamland.entity.game.GameInfo;

public interface PageListQueryDao {

	List<CustInfo> findCustList(CustInfo where);
	
	List<GameInfo> findGameList(GameInfo where);
	
}

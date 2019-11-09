package org.oversky.dreamland.ext.dao;

import java.util.List;
import org.oversky.dreamland.entity.cust.CustInfo;

public interface PageListQueryDao {

	List<CustInfo> findCusts(CustInfo where);
	
}

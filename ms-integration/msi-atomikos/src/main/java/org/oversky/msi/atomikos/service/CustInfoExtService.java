package org.oversky.msi.atomikos.service;

import org.oversky.dreamland.entity.cust.CustInfoExt;

public interface CustInfoExtService {
	void save(CustInfoExt cust);
	
	void delete(Long custNo);

}

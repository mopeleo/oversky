package org.oversky.msi.atomikos.service;

import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.gurms.system.entity.SysRole;

public interface BusinessService {

	public void saveDao(SysRole role, CustInfoExt custExt, boolean flag);
	
	public void updateDao(SysRole role, CustInfoExt custExt, boolean flag);
	
	public void deleteDao(Long roleid, Long custno, boolean flag);

	public void saveService(SysRole role, CustInfoExt custExt, boolean flag);
	
	public void updateService(SysRole role, CustInfoExt custExt, boolean flag);
	
	public void deleteService(Long roleid, Long custno, boolean flag);
}

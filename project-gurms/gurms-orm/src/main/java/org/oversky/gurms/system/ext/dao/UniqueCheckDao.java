package org.oversky.gurms.system.ext.dao;

public interface UniqueCheckDao {

	int existUserMobile(String mobileno);
	
	int existOrgNameUpdate(String orgName, Long orgId, Long parentId);

}

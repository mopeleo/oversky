package org.oversky.gurms.system.ext.dao;

public interface UniqueCheckDao {

	int existLoginId(String loginid);
	
	int existUserMobile(String mobileno);
	
	int existUserMobileUpdate(Long userid, String mobileno);
	
	int existOrgNameUpdate(Long orgId, String orgName, Long parentId);

}

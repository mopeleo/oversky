package org.oversky.gurms.system.ext.dao;

public interface UniqueCheckDao {

	int existRoleName(String roleName);
	
	int existUserLoginId(String loginId);
	
	int existUserMobile(String mobileno);
}

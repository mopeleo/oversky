package org.oversky.dreamland.ext.dao;

public interface UniqueCheckDao {

	int existLoginId(String loginId);
	
	int existUserMobile(String mobileNo);
	
	int existUserMobileUpdate(Long custno, String mobileNo);
}

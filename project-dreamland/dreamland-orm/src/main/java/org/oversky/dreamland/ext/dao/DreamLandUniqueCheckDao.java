package org.oversky.dreamland.ext.dao;

public interface DreamLandUniqueCheckDao {

	int existLoginId(String loginId);
	
	int existMobileNo(String mobileNo);
	
	int uptExistMobileNo(Long custno, String mobileNo);
}

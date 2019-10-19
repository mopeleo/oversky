package org.oversky.gurms.system.service;

import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;

public interface LoginService {

	public void home();
	
	public UserLoginRes login(UserLoginReq loginReq);
	
	public String getJWToken(UserLoginRes userInfo);
	
	public void logout();
}

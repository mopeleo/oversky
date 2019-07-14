package org.oversky.gurms.web.util;

import org.oversky.gurms.system.dto.response.UserLoginRes;

public class WebContext {

	private static ThreadLocal<UserLoginRes> USER_SESSION = new ThreadLocal<UserLoginRes>();
	
	public static UserLoginRes getUserSession() {
		return USER_SESSION.get();
	}
	
	public static void setUserSession(UserLoginRes user) {
		USER_SESSION.set(user);
	}
}

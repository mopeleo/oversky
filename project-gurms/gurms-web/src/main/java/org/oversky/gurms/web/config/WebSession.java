package org.oversky.gurms.web.config;

import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@CacheConfig(cacheNames = "webSession")
@Component
public class WebSession {
	
	@Cacheable(key = "'session_'+ #p0.userid", unless = "#result == null")
	public UserLoginRes cacheSession(UserLoginRes res) {
		
		return res;
	}
	
	@Cacheable(key = "'session_'+ #p0")
	public UserLoginRes getSession(Long userId) {
		return null;
	}

}

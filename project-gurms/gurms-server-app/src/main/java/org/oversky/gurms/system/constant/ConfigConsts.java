package org.oversky.gurms.system.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//可以指定其他配置文件,不配置默认为classpath:/application.properties
//@PropertySource(value = "classpath:/other.properties")
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "gurms.config")
public final class ConfigConsts {

	private boolean redisEnable;

	public boolean isRedisEnable() {
		return redisEnable;
	}

	public void setRedisEnable(boolean redisEnable) {
		this.redisEnable = redisEnable;
	}	
}

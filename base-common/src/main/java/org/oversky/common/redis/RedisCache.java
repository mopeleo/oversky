package org.oversky.common.redis;

import java.util.concurrent.TimeUnit;

import org.oversky.common.spring.SpringBeanUtils;
import org.oversky.util.json.JacksonUtils;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache {

	private static RedisTemplate<String, String> redisTemplate = SpringBeanUtils.getBean("redisTemplate");

	public static void set(final String key, Object value) {
        String val = JacksonUtils.bean2Json(value);
        redisTemplate.opsForValue().set(key, val);
    }

	public static void set(final String key, Object value, Long expireTime) {
        String val = JacksonUtils.bean2Json(value);
        redisTemplate.opsForValue().set(key, val);
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    public static <T> T get(final String key, Class<T> clazz) {
        String json = redisTemplate.opsForValue().get(key);
        return JacksonUtils.json2Bean(json, clazz);
    }

    public static boolean del(final String key) {
    	if(exist(key)) {
    		return redisTemplate.delete(key);
    	}
    	
    	return false;
    }
    
    public static boolean exist(final String key) {
        return redisTemplate.hasKey(key);
    }
}
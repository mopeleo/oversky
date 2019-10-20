package org.oversky.common.redis;

import org.oversky.common.spring.SpringBeanUtils;
import org.oversky.util.json.JacksonUtils;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache {

	private static RedisTemplate<String, String> redisTemplate = SpringBeanUtils.getBean("redisTemplate");

	public static void set(String key, Object value) {
        String val = JacksonUtils.bean2Json(value);
        redisTemplate.opsForValue().set(key, val);
    }

    public static <T> T get(String key, Class<T> clazz) {
        String json = redisTemplate.opsForValue().get(key);
        return JacksonUtils.json2Bean(json, clazz);
    }

    public static boolean del(String key) {
        return redisTemplate.delete(key);
    }
}
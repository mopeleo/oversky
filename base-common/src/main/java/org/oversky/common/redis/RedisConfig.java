package org.oversky.common.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfig {
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		// value序列化方式采用jackson
		RedisSerializer<Object> serializer = this.valueSerializer();
		template.setValueSerializer(serializer);
		template.setHashValueSerializer(serializer);
		template.afterPropertiesSet();
		return template;
	}
	
	private RedisSerializer<Object> valueSerializer(){
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		//将RedisTemplate的Value序列化方式由JdkSerializationRedisSerializer更换为Jackson2JsonRedisSerializer
        //此种序列化方式结果清晰、容易阅读、存储字节少、速度快
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		return jackson2JsonRedisSerializer;
	}
}

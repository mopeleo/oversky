package org.oversky.gurms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@MapperScan({"org.oversky.gurms.system.dao","org.oversky.gurms.system.*.dao"})
@EnableTransactionManagement
public class GurmsMicroServer {
	
	public static void main(String[] args) {
		SpringApplication.run(GurmsMicroServer.class, args);
	}
}

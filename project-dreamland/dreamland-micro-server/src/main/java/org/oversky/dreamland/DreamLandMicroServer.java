package org.oversky.dreamland;

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
@MapperScan({"org.oversky.dreamland.dao.*","org.oversky.dreamland.ext.dao"})
@EnableTransactionManagement
public class DreamLandMicroServer {
	
	public static void main(String[] args) {
		SpringApplication.run(DreamLandMicroServer.class, args);
	}
}

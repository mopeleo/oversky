package org.oversky.msi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServer {

	//spring cloud gateway 配置方式之一，启动主程序配置，还有一种是配置文件配置
//	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/qq/**").and().uri("http://www.qq.com/"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServer.class, args);
	}
}

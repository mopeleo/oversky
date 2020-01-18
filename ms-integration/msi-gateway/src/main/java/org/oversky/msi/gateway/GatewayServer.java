package org.oversky.msi.gateway;

import org.oversky.msi.gateway.filter.RequestTimeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServer {

	//spring cloud gateway 配置方式之一，启动主程序配置，还有一种是配置文件配置,可以同时配置，一起生效
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/gurms/3/**")
						.filters(f -> f.stripPrefix(2).filters(new RequestTimeFilter()))
						.uri("lb://gurms-server1")
						.order(0)				//值越大优先级越低
						.id("gurms-server3")
				)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServer.class, args);
	}
}

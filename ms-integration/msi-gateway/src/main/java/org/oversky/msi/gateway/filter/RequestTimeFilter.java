package org.oversky.msi.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * GatewayFilter : 需要通过spring.cloud.routes.filters 配置在具体路由下，只作用在当前路由上或通过spring.cloud.default-filters配置在全局，作用在所有路由上。
 * GlobalFilter:全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，
 * 				它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上
 * @author Blue
 *
 */
public class RequestTimeFilter implements GatewayFilter, Ordered {

	private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);
	public static final String BEGIN_TIME = "begin_time";
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		exchange.getAttributes().put(BEGIN_TIME, System.currentTimeMillis());
		return chain.filter(exchange).then(
				Mono.fromRunnable(() -> {
					Long startTime = exchange.getAttribute(BEGIN_TIME);
					if(startTime != null){
						System.out.println(("请求路径：" + exchange.getRequest().getURI().getRawPath() + ",消耗时间: " + (System.currentTimeMillis() - startTime) + "ms"));
						log.info("请求路径：" + exchange.getRequest().getURI().getRawPath() + ",消耗时间: " + (System.currentTimeMillis() - startTime) + "ms");
					}
				})
		);

	}

}

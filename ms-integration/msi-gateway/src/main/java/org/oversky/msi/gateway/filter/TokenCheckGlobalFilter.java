package org.oversky.msi.gateway.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class TokenCheckGlobalFilter implements GlobalFilter, Ordered {

	private static final Logger log = LoggerFactory.getLogger(TokenCheckGlobalFilter.class);
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		MultiValueMap<String, String> query = exchange.getRequest().getQueryParams();
		log.info("queryParams: " + query.toString());
		String token = query.getFirst("token");
		if(StringUtils.isEmpty(token)) {
			log.info( "token 为空，无法进行访问." );
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}

package org.oversky.msi.gateway.filter;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.oversky.msi.gateway.entity.GatewayResult;
import org.oversky.util.json.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
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
			ServerHttpResponse response = exchange.getResponse();
			GatewayResult<String> result = new GatewayResult<>();
			result.setReturncode("0001");
			result.setReturnmsg("token 为空，无法进行访问");
			byte[] datas = JacksonUtils.bean2Json(result).getBytes(StandardCharsets.UTF_8);
			DataBuffer buffer = response.bufferFactory().wrap(datas);
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
			return response.writeWith(Mono.just(buffer));
//			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}

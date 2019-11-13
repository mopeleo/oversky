package org.oversky.dreamland.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oversky.common.web.WebUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtAuthTokenInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("clientIp", WebUtils.getClientIp());
		String requestUrl = request.getServletPath().substring(1);
		
		return true;
	}
	
}

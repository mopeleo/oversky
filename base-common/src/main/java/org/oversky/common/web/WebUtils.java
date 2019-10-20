package org.oversky.common.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebUtils {

	private static HttpServletRequest request = null;

	@Autowired
	public void setRequest(HttpServletRequest httpRequest) {
		request = httpRequest;
	}

	public static String getClientIp() {
		String ip = "";

		if (request != null) {
			ip = request.getHeader("x-forwarded-for");
			if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("X-Real-IP");
			}
			if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}

		return ip;
	}
}

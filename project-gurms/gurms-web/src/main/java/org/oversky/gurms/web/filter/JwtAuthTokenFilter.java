package org.oversky.gurms.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.util.CommonUtils;
import org.oversky.gurms.common.jwt.JwtTokenUtil;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.gurms.web.config.WebException;
import org.oversky.gurms.web.config.WebSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private SysMenuService menuService;
	
	@Autowired
	private WebSession session;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestUrl = request.getServletPath().substring(1);		
		String excludeUrls = this.getFilterConfig().getInitParameter("excludeUrls");
		boolean ignore = true;
		if(!StringUtils.isEmpty(excludeUrls)) {
			ignore = CommonUtils.existSuffix(requestUrl, excludeUrls.split(","));
		}
		if(!ignore) {
			SysMenuRes menu = menuService.getMenuByUrl(requestUrl);
			if(menu != null) {
				if(menu.getAccesstype() != DictConsts.MENU_ACCESSTYPE_ANY) {
					String authToken = request.getHeader("Authorization");
					if (!StringUtils.isEmpty(authToken)) {
						if(JwtTokenUtil.isExpiration(authToken)) {
							//过期返回登陆页面
							throw new WebException(401, "用户已过期，请重新登录");
						}else {
							String userId = JwtTokenUtil.parseToken(authToken);
							//缓存查userid是否存在
							UserLoginRes res = session.getSession(Long.parseLong(userId));
							if(res == null) {
								throw new WebException(401, "用户已过期，请重新登录");
							}else {
								if(menu.getAccesstype() == DictConsts.MENU_ACCESSTYPE_AUTH) {
									SysMenuRes menus = menuService.getUserMenuTree(Long.parseLong(userId));
									if(!hasPrivilege(menu.getMenuid(), menus)) {
										throw new WebException(403, "此页面需授权才能访问");
									}
								}								
							}							
						}
					}else {
						throw new WebException(401, "登录才能访问，请重新登录");
					}			
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}

	private boolean hasPrivilege(String menuId, SysMenuRes menus){
		if(menus == null){
			return false;
		}
		
		if(menus.getMenutype() == 0){
			for(SysMenuRes m : menus.getSubMenus()){
				if(hasPrivilege(menuId, m)){
					return true;
				}
			}
		}else{
			return menus.getMenuid().equals(menuId);
		}
		return false;
	}
}

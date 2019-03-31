package org.oversky.gurms.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseServiceException;
import org.oversky.base.util.CommonUtils;
import org.oversky.gurms.common.jwt.JwtTokenUtil;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private SysMenuService menuService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestUrl = request.getServletPath();
		
//		if(!menuService.isCorrectUrl(requestUrl)) {
//			throw new BaseServiceException("错误的URL地址");
//		}
		
		String excludeUrls = this.getFilterConfig().getInitParameter("excludeUrls");
		boolean ignore = true;
		if(!StringUtils.isEmpty(excludeUrls)) {
			ignore = CommonUtils.existSuffix(requestUrl, excludeUrls.split(","));
		}
		if(!ignore) {
			SysMenuRes menu = menuService.getMenuByUrl(requestUrl);
			if(menu != null) {
				if(menu.getAccesstype() != DictConsts.MENU_ACCESSTYPE_ANY) {
					String authHeader = request.getHeader("Authorization");
					if (authHeader != null && authHeader.startsWith("Bearer")) {
						String authToken = authHeader.substring(7);
						if(JwtTokenUtil.isExpiration(authToken)) {
							//TODO 过期返回登陆页面
							response.setStatus(401);
							response.sendRedirect("/login");
						}
						String userId = JwtTokenUtil.parseToken(authToken);
						//TODO 缓存查userid是否存在
						
						if(menu.getAccesstype() == DictConsts.MENU_ACCESSTYPE_AUTH) {
							SysMenuRes menus = menuService.getUserMenuTree(Long.parseLong(userId));
							if(!hasPrivilege(menu.getMenuid(), menus)) {
								throw new BaseServiceException("此页面需授权才能访问");
							}
						}
					}else {
						//TODO 跳转到登录页面
						response.setStatus(401);
						response.sendRedirect("/login");
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

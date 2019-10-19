package org.oversky.gurms.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.oversky.gurms.common.jwt.JwtTokenUtil;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.gurms.web.config.WebException;
import org.oversky.gurms.web.util.WebContext;
import org.oversky.util.common.CommonUtils;
import org.oversky.util.json.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtAuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private SysMenuService menuService;
	
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
			//从数据库获取
			SysMenuRes menu = menuService.getMenuByUrl(requestUrl);
			if(menu != null && !DictConsts.DICT2011_ACCESSTYPE_ANY.equals(menu.getAccesstype())) {
				if(DictConsts.DICT2011_ACCESSTYPE_AUTH.equals(menu.getAccesstype())) {
					String authToken = request.getHeader("Authorization");
					String subject = null;
					try {
						subject = JwtTokenUtil.getSubject(authToken);
					}catch(ExpiredJwtException e) {
						throw new WebException(401, "用户已过期，请重新登录");
					}catch(Exception e) {
						throw new WebException(500, "非法的token，请重新登录获取合法token");
					}
					UserLoginRes userAuth = JacksonUtils.json2Bean(subject, UserLoginRes.class);
					//绑定用户session
					WebContext.setUserSession(userAuth);
					//用户权限
					String menuList = userAuth.getToken();
					if(("," + menuList + ",").indexOf("," + menu.getMenuid() + ",") < 0) {
						throw new WebException(404, "此页面需授权才能访问");
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
		
		if(DictConsts.DICT2010_MENYTYPE_DIRECTORY.equals(menus.getMenutype())){
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

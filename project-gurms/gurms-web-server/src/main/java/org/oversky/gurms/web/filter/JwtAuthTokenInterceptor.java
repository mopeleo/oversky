package org.oversky.gurms.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oversky.common.jwt.JwtTokenUtil;
import org.oversky.common.web.WebUtils;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.gurms.web.config.WebException;
import org.oversky.gurms.web.util.WebContext;
import org.oversky.util.json.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtAuthTokenInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SysMenuService menuService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("clientIp", WebUtils.getClientIp());
		String requestUrl = request.getServletPath().substring(1);
//		String resourceId = request.getParameter("resourceid");
//		String userId = request.getParameter("userid");
//		System.out.println("================resourceId : " + resourceId + "===================");
//		System.out.println("================userId : " + userId + "===================");
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
		
		return true;
	}
	
	private boolean hasPrivilege(String menuId, SysMenuRes menus){
		if(menus == null || menuId == null){
			return false;
		}
		if(menuId.equals(menus.getMenuid())) {
			return true;
		}
		if(menus.getSubMenus() != null && menus.getSubMenus().size() > 0){
			for(SysMenuRes m : menus.getSubMenus()){
				if(hasPrivilege(menuId, m)){
					return true;
				}
			}
		}
		return false;
	}
}

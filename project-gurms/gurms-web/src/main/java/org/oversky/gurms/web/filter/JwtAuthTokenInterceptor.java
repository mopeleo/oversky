package org.oversky.gurms.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.oversky.gurms.common.json.JacksonUtils;
import org.oversky.gurms.common.jwt.JwtTokenUtil;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dto.response.SysMenuRes;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.SysMenuService;
import org.oversky.gurms.web.config.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtAuthTokenInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SysMenuService menuService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl = request.getServletPath().substring(1);		
		//从数据库获取
		SysMenuRes menu = menuService.getMenuByUrl(requestUrl);
		if(menu != null && menu.getAccesstype() != DictConsts.MENU_ACCESSTYPE_ANY) {
			String authToken = request.getHeader("Authorization");
			//过期返回登陆页面
			if(JwtTokenUtil.isExpiration(authToken)) {
				throw new WebException(401, "用户已过期，请重新登录");
			}
			
			if(!JwtTokenUtil.verifyToken(authToken)) {
				throw new WebException(500, "非法的token，请重新登录获取token");
			}
			
			if(menu.getAccesstype() == DictConsts.MENU_ACCESSTYPE_AUTH) {
				String subject = JwtTokenUtil.getSubject(authToken);
				UserLoginRes userAuth = JacksonUtils.json2Bean(subject, UserLoginRes.class);
				
				//用户权限
				SysMenuRes menus = userAuth.getMenuTree();
				if(!hasPrivilege(menu.getMenuid(), menus)) {
					throw new WebException(404, "此页面需授权才能访问");
				}
			}				
		}
		
		return true;
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

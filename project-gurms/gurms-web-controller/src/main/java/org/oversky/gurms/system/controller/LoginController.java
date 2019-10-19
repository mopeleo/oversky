package org.oversky.gurms.system.controller;

import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.LoginService;
import org.oversky.gurms.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public UserLoginRes login(@RequestBody UserLoginReq user) {
		user.setClientIp(WebUtils.getClientIp());
		UserLoginRes res = loginService.login(user);
		
		if(res.isSuccess()) {
			String token = loginService.getJWToken(res);
			res.setToken(token);
		}
		return res;
	}
	
	@RequestMapping("/logout/{userId}")
	public boolean logout(@PathVariable Long userId) {
		return true;
	}
}

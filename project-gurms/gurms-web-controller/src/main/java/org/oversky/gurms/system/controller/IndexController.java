package org.oversky.gurms.system.controller;

import org.oversky.gurms.common.jwt.JwtTokenUtil;
import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.IndexService;
import org.oversky.gurms.web.util.WebUtils;
import org.oversky.util.json.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@RequestMapping("/login")
	public UserLoginRes login(@RequestBody UserLoginReq user) {
		user.setClientIp(WebUtils.getClientIp());
		UserLoginRes res = indexService.login(user);
		if(res.isSuccess()) {
			String token = JwtTokenUtil.generateToken(JacksonUtils.bean2JsonIgnoreNull(res));
			res.setToken(token);
		}
		return res;
	}
	
	@RequestMapping("/logout/{userId}")
	public boolean logout(@PathVariable Long userId) {
		return true;
	}
}

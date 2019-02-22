package org.oversky.gurms.web.controller;

import org.oversky.gurms.system.dto.request.UserLoginReq;
import org.oversky.gurms.system.dto.response.UserLoginRes;
import org.oversky.gurms.system.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@RequestMapping("/login")
	public UserLoginRes login(@RequestBody UserLoginReq user) {
		return indexService.login(user);
	}
}

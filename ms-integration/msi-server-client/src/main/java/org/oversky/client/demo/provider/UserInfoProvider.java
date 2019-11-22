package org.oversky.client.demo.provider;

import org.oversky.client.demo.gurms.api.SysUserClient;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class UserInfoProvider {

	@Autowired
	private SysUserClient userClient;
	
	@RequestMapping("/user")
	public SysUserRes userInfo(Long userid) {
		System.out.println("userid : " + userid);
		return userClient.userInfo(userid);
	}
	
	@RequestMapping("/roleadd/{rolename}")
	public SysRoleRes roleAdd(@PathVariable String rolename) {
		System.out.println("rolename : " + rolename);
		SysRoleReq req = new SysRoleReq();
		req.setRolename(rolename);
		req.setCreator(2L);
		req.setEnddate("20190101");
		req.setStartdate("20180101");
		req.setStatus("1");
		req.setUnioncode("0000");
		return userClient.roleAdd(req);
	}
	
	@GetMapping("/hello")
	public String hello(String msg) {
		return "Hello, " + msg;
	}
}

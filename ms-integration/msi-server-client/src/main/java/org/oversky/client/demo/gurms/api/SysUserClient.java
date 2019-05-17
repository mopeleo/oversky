package org.oversky.client.demo.gurms.api;

import org.oversky.client.demo.gurms.fallback.SysUserClientHystrix;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gurms-server", fallback = SysUserClientHystrix.class)
public interface SysUserClient {

	@GetMapping("/sysuser/detail")
	public SysUserRes userInfo(@RequestParam("userid") Long userid);
	
	@RequestMapping(value = "/sysrole/add", method = RequestMethod.POST)
	public SysRoleRes roleAdd(@RequestBody SysRoleReq role);
}

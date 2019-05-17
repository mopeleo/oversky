package org.oversky.client.demo.gurms.fallback;

import org.oversky.client.demo.gurms.api.SysUserClient;
import org.oversky.gurms.system.dto.request.SysRoleReq;
import org.oversky.gurms.system.dto.response.SysRoleRes;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.springframework.stereotype.Component;

@Component
public class SysUserClientHystrix implements SysUserClient {

	@Override
	public SysUserRes userInfo(Long userId) {
		// TODO Auto-generated method stub
		System.out.println("userInfo call failure......");
		return null;
	}

	@Override
	public SysRoleRes roleAdd(SysRoleReq role) {
		// TODO Auto-generated method stub
		System.out.println("roleAdd call failure......");
		SysRoleRes res = new SysRoleRes();
		res.failure("调用失败");
		return res;
	}

}

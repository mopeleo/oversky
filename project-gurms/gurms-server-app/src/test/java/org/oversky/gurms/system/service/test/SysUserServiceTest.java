package org.oversky.gurms.system.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

	@Autowired
	private SysUserService sysUserService;
	
	@Test
	public void insert() {
		System.out.println("=======sysUserService.insert=======");
		SysUserReq userDto = new SysUserReq();
		userDto.setUserid(1L);
		userDto.setEmail("test@126.com");
		userDto.setIdcode("421001297608160946");
		userDto.setIdtype("1");
		userDto.setLogindate("20190130");
		userDto.setLoginerror(0);
		userDto.setLoginid("hyh");
		userDto.setLoginpasswd("1");
		userDto.setLogintime("150000");
		userDto.setMobileno("13554600998");
		userDto.setOrgid("0001");
		userDto.setPasswdvaliddate("20190909");
		userDto.setSalt("123");
		userDto.setStatus(1);
		userDto.setUnioncode("0000");
		userDto.setUsername("黄勇华");
		boolean flag = sysUserService.insert(userDto);
		System.out.println(flag);
	}
}

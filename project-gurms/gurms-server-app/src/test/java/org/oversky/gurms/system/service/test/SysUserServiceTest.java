package org.oversky.gurms.system.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
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
		SysUserReq userDto = new SysUserReq();
		userDto.setUserid(2L);
		userDto.setEmail("tt@126.com");
		userDto.setIdcode("421001297608160946");
		userDto.setIdtype("1");
		userDto.setLogindate("20190130");
		userDto.setLoginerror(0);
		userDto.setLoginid("tt");
		userDto.setLoginpasswd("1");
		userDto.setLogintime("150000");
		userDto.setMobileno("13554600998");
		userDto.setOrgid("0001");
		userDto.setPasswdvaliddate("20190909");
		userDto.setSalt("123");
		userDto.setStatus(1);
		userDto.setUnioncode("0000");
		userDto.setUsername("天天");
		boolean flag = sysUserService.insert(userDto);
		Assert.assertEquals(false, flag);
	}
	
	@Test
	public void query() {
		SysUserReq userDto = new SysUserReq();
		userDto.setUserid(2L);
		List<SysUserRes> res = sysUserService.find(userDto);
		Assert.assertSame("不一样呀", 1, res.size());
		System.out.println(res);
	}
	
}

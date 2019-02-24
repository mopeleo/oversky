package org.oversky.gurms.system.service.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.gurms.system.dao.ext.SysUserDaoExt;
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
	
	@Autowired
	private SysUserDaoExt userDaoExt;
	
//	@Test
	public void insert() {
		SysUserReq userDto = new SysUserReq();
		userDto.setUserid(3L);
		userDto.setEmail("test@126.com");
		userDto.setIdcode("421001297608160946");
		userDto.setIdtype("1");
		userDto.setLogindate("20190130");
		userDto.setLoginerror(0);
		userDto.setLoginid("test");
		userDto.setLoginpasswd("1");
		userDto.setLogintime("150000");
		userDto.setMobileno("13554600998");
		userDto.setOrgid(10000);
		userDto.setPasswdvaliddate("20190909");
		userDto.setSalt("123");
		userDto.setStatus(1);
		userDto.setUnioncode("0000");
		userDto.setUsername("test");
		boolean flag = sysUserService.insert(userDto);
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void query() {
		SysUserReq userDto = new SysUserReq();
		userDto.setUserid(2L);
		List<SysUserRes> res = sysUserService.find(userDto);
		Assert.assertSame("不一样呀", 1, res.size());
		System.out.println(res);
	}
	
	@Test
	public void testDaoExt() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", 1L);
		List<Map<String, Object>> list = userDaoExt.getUserRole(map);
		for(Map<String, Object> result : list) {
			result.forEach((k, v) -> {
				System.out.print(k + ":" + v + ", ");
			});
			for(Map.Entry<String, Object> entry : result.entrySet()) {
				System.out.print(entry.getKey() + ":" + entry.getValue() + ", ");
			}
			System.out.println();
		}
	}
	
}

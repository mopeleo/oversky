package org.oversky.gurms.system.service.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dao.ext.UserRightDao;
import org.oversky.gurms.system.dao.ext.bo.SysUserBO;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.entity.SysUser;
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
	private UserRightDao userDaoExt;
	
	@Autowired
	private SysUserDao userDao;
	
//	@Test
	public void insert() {
		SysUserReq userDto = new SysUserReq();
		userDto.setEmail("test@12611.com");
		userDto.setIdcode("421001297608160946");
		userDto.setIdtype("1");
		userDto.setLogindate("20190130");
		userDto.setLoginerror(0);
		userDto.setLoginid("test");
		userDto.setLoginpasswd("1");
		userDto.setLogintime("150000");
		userDto.setMobileno("13554600998");
		userDto.setOrgid(10000L);
		userDto.setPasswdvaliddate("20190909");
		userDto.setSalt("123");
		userDto.setStatus(1);
		userDto.setUnioncode("0000");
		userDto.setUsername("test");
		boolean flag = sysUserService.insert(userDto).isSuccess();
		Assert.assertEquals(true, flag);
	}
	
//	@Test
	public void testDaoExt() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", 1L);
		List<Map<String, Object>> list = userDaoExt.testUserRoles(map);
		for(Map<String, Object> result : list) {
			result.forEach((k, v) -> {
				System.out.print(k + ":" + v + ", ");
			});
//			for(Map.Entry<String, Object> entry : result.entrySet()) {
//				System.out.print(entry.getKey() + ":" + entry.getValue() + ", ");
//			}
			System.out.println();
		}
	}
	
//	@Test
	public void testGetUserRolesAndMenus() {
		System.out.println("-----------begin  testGetUserRolesAndMenus------------");
		SysUserBO bo = userDaoExt.getUserRolesAndMenus(1L);
		System.out.println(bo.getSysorg().getShortname());
		System.out.println(bo.getRoles().size());
		System.out.println(bo.getMenus().size());
		System.out.println("-----------end  testGetUserRolesAndMenus------------");
	}
	
//	@Test
	public void testPage() {
		SysUserReq userDto = new SysUserReq();
		userDto.setPageNum(2);
		userDto.setPageSize(5);
		BaseResListDto<SysUserRes> res = sysUserService.pageSysUser(userDto);
		System.out.println(res);
		System.out.println("-----------------------");
		for(SysUserRes user :  res.getResults()) {
			System.out.println(user);
		}
	}
	
//	@Test
	public void testBatchInsert() {
		int len = 5;
		List<SysUser> list = new ArrayList<SysUser>(len);
		for(int i = 0; i < len; i++) {
			SysUser userDto = new SysUser();
			userDto.setEmail("hyh@126.com");
			userDto.setIdcode("421001297608160946");
			userDto.setIdtype("1");
			userDto.setLogindate("20190130");
			userDto.setLoginerror(i);
			userDto.setLoginid("test");
			userDto.setLoginpasswd("1");
			userDto.setLogintime("150000");
			userDto.setMobileno("13554600998");
			userDto.setOrgid(10000);
			userDto.setPasswdvaliddate("20190909");
			userDto.setSalt("123");
			userDto.setStatus(1);
			userDto.setUnioncode("0000");
			userDto.setUsername("test"+i);
			list.add(userDto);
		}
		int r = userDao.insertBatch(list);
		System.out.println(r);
	}
	
//	@Test
	public void testBatchUpdate() {
		SysUser where = new SysUser();
		where.setLoginid("test");
		List<SysUser> list = userDao.selectWhere(where);
		for(int i = 0; i < list.size(); i++) {
			SysUser user = list.get(i);
			if(user.getUserid()%2 == 0) {
				user.setUnioncode("u-" + i);
			}else {
				user.setUnioncode("u+" + i);
			}
//			user.setUnioncode("0000");
		}
		int r = userDao.updateBatch(list);
		System.out.println(r);
	}
	
	@Test
	public void testBatchDelete() {
		Long[] ids = {26L,40L};
		int r = userDao.deleteBatch(ids);
		System.out.println(r);
	}
}

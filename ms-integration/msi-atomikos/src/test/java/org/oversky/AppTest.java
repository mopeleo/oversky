package org.oversky;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.msi.atomikos.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  
@SpringBootTest(classes = App.class)
public class AppTest{

	@Autowired
	private BusinessService busiService;
	
	@Test
	public void save() {
		SysRole role = new SysRole();
		role.setRolename(String.valueOf(Math.round(Math.random()*1000)));
		role.setUnioncode("0100");
		role.setStatus("1");
		role.setCreator(21L);
		CustInfoExt custExt = new CustInfoExt();
		custExt.setCustno(System.currentTimeMillis());
		custExt.setSex("1");
		busiService.saveService(role, custExt, true);
	}
	
//	@Test
	public void update() {
		SysRole role = new SysRole();
		CustInfoExt custExt = new CustInfoExt();
		boolean flag = false;
		busiService.updateDao(role, custExt, flag);
	}
	
//	@Test
	public void delete() {
		Long roleid = 1L;
		Long custno = 1L;
		boolean flag = true;
		busiService.deleteDao(roleid, custno, flag);
	}
}

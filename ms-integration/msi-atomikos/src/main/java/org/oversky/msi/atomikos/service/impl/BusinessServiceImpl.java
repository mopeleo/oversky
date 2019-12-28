package org.oversky.msi.atomikos.service.impl;

import org.oversky.dreamland.dao.cust.CustInfoExtDao;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.gurms.system.dao.SysRoleDao;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.msi.atomikos.service.BusinessService;
import org.oversky.msi.atomikos.service.CustInfoExtService;
import org.oversky.msi.atomikos.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private SysRoleDao roleDao;
	
	@Autowired
	private CustInfoExtDao custExtDao;
	
	@Autowired
	private SysRoleService roleService;
	
	@Autowired
	private CustInfoExtService custService;
	
	
	@Transactional
	public void saveDao(SysRole role, CustInfoExt custExt, boolean flag) {
		roleDao.insert(role);
		custExtDao.insert(custExt);
		if(flag) {
			throw new RuntimeException("测试分布式事务(tx+aop形式)");
		}
		System.out.println("save success");
	}
	
	@Transactional
	public void updateDao(SysRole role, CustInfoExt custExt, boolean flag) {
		roleDao.dynamicUpdateById(role);
		custExtDao.dynamicUpdateById(custExt);
		if(flag) {
			throw new RuntimeException("测试分布式事务(注解形式)");
		}
		System.out.println("update success");
	}
	
	public void deleteDao(Long roleid, Long custno, boolean flag) {
		roleDao.deleteById(roleid);
		custExtDao.deleteById(custno);
		if(flag) {
			throw new RuntimeException("测试没有添加分布式事务管理");
		}
		System.out.println("delete success");
	}
	
	@Transactional
	public void saveService(SysRole role, CustInfoExt custExt, boolean flag) {
		roleService.save(role);
		custService.save(custExt);
		if(flag) {
			throw new RuntimeException("测试分布式事务(tx+aop形式)");
		}
		System.out.println("save success");
	}
	
	@Transactional
	public void updateService(SysRole role, CustInfoExt custExt, boolean flag) {
		roleDao.dynamicUpdateById(role);
		custExtDao.dynamicUpdateById(custExt);
		if(flag) {
			throw new RuntimeException("测试分布式事务(注解形式)");
		}
		System.out.println("update success");
	}
	
	public void deleteService(Long roleid, Long custno, boolean flag) {
		roleService.delete(roleid);
		custService.delete(custno);
		if(flag) {
			throw new RuntimeException("测试没有添加分布式事务管理");
		}
		System.out.println("delete success");
	}
}

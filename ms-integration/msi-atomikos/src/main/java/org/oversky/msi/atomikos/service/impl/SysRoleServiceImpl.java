package org.oversky.msi.atomikos.service.impl;

import org.oversky.gurms.system.dao.SysRoleDao;
import org.oversky.gurms.system.entity.SysRole;
import org.oversky.msi.atomikos.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao roleDao;
	
	@Override
	@Transactional
	public void save(SysRole role) {
		// TODO Auto-generated method stub
		roleDao.insert(role);
	}

	@Override
	@Transactional
	public void delete(Long roleId) {
		// TODO Auto-generated method stub
		roleDao.deleteById(roleId);
	}

}

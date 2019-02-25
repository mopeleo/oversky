package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.util.BeanCopyUtils;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUserRes login(SysUserReq userReq) {
		// TODO Auto-generated method stub
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		System.out.println(userReq.getPasswdvaliddate());
		sysUserDao.insert(user);
		return null;
	}

	@Override
	public boolean insert(SysUserReq userReq) {
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		return sysUserDao.insert(user) == 1;
	}

	@Override
	public boolean delete(Long userid) {
		return sysUserDao.deleteById(userid) == 1;
	}

	@Override
	public boolean update(SysUserReq userReq) {
		return false;
	}

	@Override
	public SysUserRes getById(Long userid) {
		SysUser user = sysUserDao.getById(userid);
		return BeanCopyUtils.convert(user, SysUserRes.class);
	}

	public List<SysUserRes> find(SysUserReq userReq){
		SysUser where = BeanCopyUtils.convert(userReq, SysUser.class);
		List<SysUser> userList = sysUserDao.selectWhere(where);
		return BeanCopyUtils.convertList(userList, SysUserRes.class);
	}
}

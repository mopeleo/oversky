package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.util.BeanCopyUtils;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUserRes insert(SysUserReq userReq) {
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		SysUserRes res = new SysUserRes();
		if(sysUserDao.insert(user) == 1) {
			res.success("新增成功");
		}else {
			res.failure("新增失败");
		}
		return res;
	}

	@Override
	public SysUserRes delete(Long userid) {
		SysUserRes res = new SysUserRes();
		if(sysUserDao.deleteById(userid) == 1) {
			res.success("删除成功");
		}else {
			res.failure("删除失败");
		}
		return res;
	}

	@Override
	public SysUserRes update(SysUserReq userReq) {
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		SysUserRes res = new SysUserRes();
		if(sysUserDao.updateById(user) == 1) {
			res.success("修改成功");
		}else {
			res.failure("修改失败");
		}
		return res;
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
	
	//PageHelper 方法使用了静态的 ThreadLocal 参数，分页参数和线程是绑定的
	//只要你可以保证在 PageHelper 方法调用后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象。
	public BaseResListDto<SysUserRes> pageSysUser(SysUserReq userReq){
		Page<SysUser> page = PageHelper.startPage(userReq.getPageNum(), userReq.getPageSize());
		List<SysUser> userList = sysUserDao.selectAll();
		List<SysUserRes> userResList = BeanCopyUtils.convertList(userList, SysUserRes.class);
		
		BaseResListDto<SysUserRes> resList = new BaseResListDto<SysUserRes>();
		resList.setResults(userResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		return resList;
	}
}

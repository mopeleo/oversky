package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.ext.dao.ListQueryDao;
import org.oversky.gurms.system.service.SysUserService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.util.common.CommonUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.encode.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{
	
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private ListQueryDao queryDao;
	
	@Override
	public SysUserRes insert(SysUserReq userReq) {
		SysUserRes res = new SysUserRes();
		if(!this.check(userReq, res)) {
			return res;
		}
		
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		user.setSalt(CommonUtils.getRandomString(8));
		user.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		user.setLoginerror(0);
		user.setPasswdvaliddate(DateUtils.addMonths(DateUtils.getNowDate(),3));
		if(!StringUtils.isEmpty(user.getLoginpasswd())) {
			String md5Passwd = EncryptUtils.md5Encode(user.getLoginpasswd());
			user.setLoginpasswd(EncryptUtils.md5Encode(md5Passwd + user.getSalt()));
		}
		if(sysUserDao.insert(user) == 1) {
			res.success("新增成功");
		}else {
			res.failure("新增失败");
		}
		return res;
	}

	@Override
	public boolean delete(Long userid) {
		return sysUserDao.deleteById(userid) == 1;
	}

	@Override
	public SysUserRes update(SysUserReq userReq) {
		SysUserRes res = new SysUserRes();
		if(!this.check(userReq, res)) {
			return res;
		}
		
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		if(sysUserDao.dynamicUpdateById(user) == 1) {
			res.success("修改成功");
		}else {
			res.failure("修改失败");
		}
		return res;
	}

	@Override
	public SysUserRes getById(Long userid) {
		log.info("开始查询用户[userid={}]信息...", userid);
		SysUser user = sysUserDao.getById(userid);
		SysUserRes res = new SysUserRes();
		if(user == null) {
			res.failure("用户不存在");
		}else {
			BeanCopyUtils.copy(user, res);
		}
		log.info("查询用户[userid={}]结束: {}", userid, res.getReturnmsg());
		return res;
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
		SysUser where = BeanCopyUtils.convert(userReq, SysUser.class);
		List<SysUser> userList = queryDao.findUsers(where);
		List<SysUserRes> userResList = BeanCopyUtils.convertList(userList, SysUserRes.class);
		
		BaseResListDto<SysUserRes> resList = new BaseResListDto<SysUserRes>();
		resList.setResults(userResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		return resList;
	}
	
	private boolean check(SysUserReq userReq, SysUserRes res) {
		if(StringUtil.isEmpty(userReq.getLoginid())) {
			res.failure("登录名不能为空");
			return false;
		}
		return true;
	}
}

package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.component.BizFunc;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.gurms.system.dao.SysOrgDao;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dao.SysUserInfoDao;
import org.oversky.gurms.system.dao.SysUserRoleDao;
import org.oversky.gurms.system.dto.request.SysUserReq;
import org.oversky.gurms.system.dto.response.SysUserRes;
import org.oversky.gurms.system.entity.SysOrg;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.entity.SysUserInfo;
import org.oversky.gurms.system.entity.SysUserRole;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
import org.oversky.gurms.system.ext.dao.UniqueCheckDao;
import org.oversky.gurms.system.service.SysUserService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.encode.EncryptUtils;
import org.oversky.valid.GSAValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{
	
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
	private SysOrgDao sysOrgDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserInfoDao userInfoDao;

	@Autowired
	private SysUserRoleDao userRoleDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;
	
	@Autowired
	private UniqueCheckDao uniqueCheckDao;
	
	@Override
	@Transactional
	@GSAValid(type=SysUserReq.class)
	public SysUserRes insert(SysUserReq userReq) {
		log.info("开始新增用户......");
		SysUserRes res = new SysUserRes();
		if(!this.check(userReq, res)) {
			return res;
		}
		
		if(uniqueCheckDao.existLoginId(userReq.getLoginid()) > 0) {
			res.failure("登录名[" + userReq.getLoginid() + "]已存在！");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(uniqueCheckDao.existUserMobile(userReq.getMobileno()) > 0) {
			res.failure("手机号码[" + userReq.getMobileno() + "]已存在！");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		user.setSalt(BizFunc.createPasswdSalt());
		user.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		user.setLoginerror(0);
		user.setOpendate(DateUtils.getNowDate());
		user.setPasswdvaliddate(BizFunc.passwordInvalidDate());
		String md5Password = user.getLoginpasswd();
		if(StringUtils.isEmpty(md5Password)) {
			String initPw = ParamConsts.getParam(user.getUnioncode(), ParamConsts.PARAM1002_PASSWD_INIT);
			md5Password = EncryptUtils.md5Encode(initPw);
		}
		user.setLoginpasswd(BizFunc.encryptPassword(md5Password, user.getSalt()));
		if(sysUserDao.insert(user) != 1) {
			res.failure("新增失败");
		}
		
		SysUserInfo userInfo = BeanCopyUtils.convert(userReq, SysUserInfo.class);
		userInfo.setUserid(user.getUserid());
		userInfoDao.insert(userInfo);
		log.info("新增用户结束 : {}", res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public SysUserRes delete(SysUserReq userReq) {
		log.info("开始删除用户[userid={}]信息...", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		//是超级用户
		if(BizFunc.isRootUser(userReq.getUserid())) {
			res.failure("超级用户不能删除");
			return res;
		}
		
		SysUser user = sysUserDao.getById(userReq.getUserid());
		if(user == null) {
			res.failure("用户[" + userReq.getUserid() + "]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(user.getStatus())) {
			res.failure("用户[" + userReq.getUserid() + "]状态异常，不能删除");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUserRole where = new SysUserRole();
		where.setUserid(userReq.getUserid());
		userRoleDao.deleteWhere(where);

		sysUserDao.deleteById(userReq.getUserid());			
		userInfoDao.deleteById(userReq.getUserid());

		res.success("删除用户成功");
		log.info("删除用户[userid={}]结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	@GSAValid(type=SysUserReq.class)
	public SysUserRes update(SysUserReq userReq) {
		log.info("开始修改用户[userid={}]信息......", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		if(!this.check(userReq, res)) {
			return res;
		}
		//是超级用户
		if(BizFunc.isRootUser(userReq.getUserid())) {
			res.failure("超级用户不能修改");
			return res;
		}
		
		if(uniqueCheckDao.existUserMobileUpdate(userReq.getUserid(), userReq.getMobileno()) > 0) {
			res.failure("手机号码[" + userReq.getMobileno() + "]已存在！");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser user = BeanCopyUtils.convert(userReq, SysUser.class);
		sysUserDao.dynamicUpdateById(user);
		log.info("修改用户[userid={}]结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes resetPassword(SysUserReq userReq) {
		log.info("开始重置用户[userid={}]密码......", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		
		SysUser user = sysUserDao.getById(userReq.getUserid());
		if(user == null) {
			res.failure("用户[" + userReq.getUserid() + "]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(user.getStatus())
				&& !DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(user.getStatus())) {
			res.failure("用户[" + userReq.getUserid() + "]状态异常，不能重置密码");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser updateUser = new SysUser();
		updateUser.setUserid(userReq.getUserid());
		updateUser.setSalt(BizFunc.createPasswdSalt());
		String md5Password = EncryptUtils.md5Encode(ParamConsts.getParam(user.getUnioncode(), ParamConsts.PARAM1002_PASSWD_INIT));
		updateUser.setLoginpasswd(BizFunc.encryptPassword(md5Password, updateUser.getSalt()));
		updateUser.setLoginerror(0);
		updateUser.setPasswdvaliddate(BizFunc.passwordInvalidDate());
		if(DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(user.getStatus())) {
			updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		}
		sysUserDao.dynamicUpdateById(updateUser);
		res.success("重置密码成功");
		log.info("重置用户[userid={}]密码结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes updatePassword(SysUserReq userReq) {
		log.info("修改用户[userid={}]密码......", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		
		SysUser user = sysUserDao.getById(userReq.getUserid());
		if(user == null) {
			res.failure("用户[" + userReq.getUserid() + "]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(userReq.getLoginpasswd().equals(userReq.getNewpasswd())) {
			res.failure("用户新密码不能与原密码相同");
			log.info(res.getReturnmsg());
			return res;
		}
		
		String oldPassword = BizFunc.encryptPassword(userReq.getLoginpasswd(), user.getSalt());
		if(!oldPassword.equals(user.getLoginpasswd())) {
			res.failure("用户原密码错误，修改密码失败");
			log.info(res.getReturnmsg());
			return res;
		}

		if(DictConsts.DICT2001_USER_STATUS_FROZEN.equals(user.getStatus())) {
			res.failure("用户[" + userReq.getUserid() + "]被冻结，不能修改密码");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser updateUser = new SysUser();
		updateUser.setUserid(userReq.getUserid());
		String newPassword = BizFunc.encryptPassword(userReq.getNewpasswd(), user.getSalt());
		updateUser.setLoginpasswd(newPassword);
		updateUser.setLoginerror(0);
		updateUser.setPasswdvaliddate(BizFunc.passwordInvalidDate());
		if(DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(user.getStatus())) {
			updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		}
		sysUserDao.dynamicUpdateById(updateUser);
		
		res.success("修改密码成功");
		log.info("修改用户[userid={}]密码结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes freezeUser(SysUserReq userReq) {
		log.info("开始冻结用户[userid={}]......", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		
		SysUser user = sysUserDao.getById(userReq.getUserid());
		if(user == null) {
			res.failure("用户[" + userReq.getUserid() + "]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(user.getStatus())) {
			res.failure("用户[" + userReq.getUserid() + "]状态异常，不能冻结");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser updateUser = new SysUser();
		updateUser.setUserid(userReq.getUserid());
		updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_FROZEN);
		sysUserDao.dynamicUpdateById(updateUser);
		res.success("冻结用户账号成功");
		log.info("冻结用户[userid={}]结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes unfreezeUser(SysUserReq userReq) {
		log.info("开始解冻用户[userid={}]......", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		
		SysUser user = sysUserDao.getById(userReq.getUserid());
		if(user == null) {
			res.failure("用户[" + userReq.getUserid() + "]不存在");
			log.info(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_FROZEN.equals(user.getStatus())) {
			res.failure("用户[" + userReq.getUserid() + "]不为冻结状态，不能冻结");
			log.info(res.getReturnmsg());
			return res;
		}
		
		SysUser updateUser = new SysUser();
		updateUser.setUserid(userReq.getUserid());
		updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		sysUserDao.dynamicUpdateById(updateUser);
		res.success("解冻用户账号成功");
		log.info("解冻用户[userid={}]结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes getById(Long userid) {
		log.info("开始查询用户[userid={}]信息...", userid);
		SysUser user = sysUserDao.getById(userid);
		SysUserRes res = new SysUserRes();
		if(user == null) {
			res.failure("用户[" + userid + "]不存在");
		}else {
			BeanCopyUtils.copy(user, res);
		}
		log.info("查询用户[userid={}]结束: {}", userid, res.getReturnmsg());
		return res;
	}

	@Override
	public SysUserRes userDetail(Long userid) {
		log.info("开始查询用户[userid={}]详细信息...", userid);
		SysUser user = sysUserDao.getById(userid);
		SysUserRes res = new SysUserRes();
		if(user == null) {
			res.failure("用户[" + userid + "]不存在");
		}else {
			BeanCopyUtils.copy(user, res);
			SysUserInfo userInfo = userInfoDao.getById(userid);
			if(userInfo != null) {
				BeanCopyUtils.copy(userInfo, res);
			}
		}
		log.info("查询用户[userid={}]详细信息结束: {}", userid, res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public SysUserRes grantRole(SysUserReq userReq) {
		log.info("开始用户[userid={}]授权...", userReq.getUserid());
		SysUserRes res = new SysUserRes();
		//是超级用户
		if(BizFunc.isRootUser(userReq.getUserid())) {
			res.failure("超级用户不能授权");
			return res;
		}
		
		//删除现有role
		SysUserRole where = new SysUserRole();
		where.setUserid(userReq.getUserid());
		userRoleDao.deleteWhere(where);
		//插入新的role
		if(userReq.getRoleList() != null) {
			String[] roles = userReq.getRoleList().split(",");
			List<SysUserRole> userRoles = new ArrayList<SysUserRole>();
			for(String roleid : roles) {
				SysUserRole sur = new SysUserRole();
				sur.setUserid(userReq.getUserid());
				sur.setRoleid(Long.parseLong(roleid));
				userRoles.add(sur);
			}
			if(userRoleDao.insertBatch(userRoles) != roles.length) {
				throw new BaseServiceException("用户[" + userReq.getUserid() + "]授权失败");
			}
		}
		log.info("授权用户[userid={}]结束: {}", userReq.getUserid(), res.getReturnmsg());
		return res;
	}

	//PageHelper 方法使用了静态的 ThreadLocal 参数，分页参数和线程是绑定的
	//只要你可以保证在 PageHelper 方法调用后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象。
	public BaseResListDto<SysUserRes> pageSysUser(SysUserReq userReq){
		log.info("开始分页查询用户信息 [req = {}]", userReq.toString());
		Page<SysUser> page = PageHelper.startPage(userReq.getPageNum(), userReq.getPageSize());
		
		if(BizFunc.isRootUnioncode(userReq.getUnioncode())) {
			userReq.setUnioncode(null);
		}
		SysUser where = BeanCopyUtils.convert(userReq, SysUser.class);
		List<SysUser> userList = pageQueryDao.findUsers(where);
		List<SysUserRes> userResList = BeanCopyUtils.convertList(userList, SysUserRes.class);
		
		BaseResListDto<SysUserRes> resList = new BaseResListDto<SysUserRes>();
		resList.setResults(userResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询用户信息结束，共查询到{}条", userResList.size());
		return resList;
	}
	
	private boolean check(SysUserReq userReq, SysUserRes res) {
		if(StringUtils.isEmpty(userReq.getLoginid())) {
			res.failure("登录名不能为空");
			return false;
		}
		
		if(userReq.getOrgid() == null) {
			res.failure("所属机构不能为空");
			return false;
		}
		
		SysOrg org = sysOrgDao.getById(userReq.getOrgid());
		if(org == null) {
			res.failure("所属机构不存在");
			return false;			
		}
		userReq.setUnioncode(org.getUnioncode());
		
		return true;
	}
}

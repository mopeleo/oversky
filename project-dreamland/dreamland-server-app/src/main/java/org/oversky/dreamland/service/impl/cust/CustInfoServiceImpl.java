package org.oversky.dreamland.service.impl.cust;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.component.BizFunc;
import org.oversky.dreamland.constant.DictConsts;
import org.oversky.dreamland.constant.ParamConsts;
import org.oversky.dreamland.dao.cust.CustInfoDao;
import org.oversky.dreamland.dao.cust.CustInfoExtDao;
import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;
import org.oversky.dreamland.entity.cust.CustInfo;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.dreamland.ext.dao.PageListQueryDao;
import org.oversky.dreamland.ext.dao.UniqueCheckDao;
import org.oversky.dreamland.service.cust.CustInfoService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.util.date.DateUtils;
import org.oversky.util.encode.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CustInfoServiceImpl implements CustInfoService {
    private static Logger log = LoggerFactory.getLogger(CustInfoServiceImpl.class);

    @Autowired
    private CustInfoDao custInfoDao;
    @Autowired
    private CustInfoExtDao custInfoExtDao;
	@Autowired
	private PageListQueryDao pageQueryDao;
	@Autowired
	private UniqueCheckDao uniqueCheckDao;

	@Override
	public CustInfoRes login(CustInfoReq req) {
		log.info("客户登录，req : {}", req.toString());
		CustInfoRes res = new CustInfoRes();
		res.success("登录成功");
		return res;
	}

	@Override
	@Transactional
	public CustInfoRes insert(CustInfoReq custReq) {
		log.info("开始新增客户......");
		CustInfoRes res = new CustInfoRes();
		if(!this.check(custReq, res)) {
			return res;
		}
		
		if(uniqueCheckDao.existLoginId(custReq.getLoginid()) > 0) {
			res.failure("登录名[" + custReq.getLoginid() + "]已存在！");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		if(uniqueCheckDao.existMobileNo(custReq.getMobileno()) > 0) {
			res.failure("手机号码[" + custReq.getMobileno() + "]已存在！");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo cust = BeanCopyUtils.convert(custReq, CustInfo.class);
		cust.setSalt(BizFunc.createPasswdSalt());
		cust.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		cust.setLoginerror(0);
		cust.setRegdate(DateUtils.getNowDate());
		cust.setCustlevel(DictConsts.DICT2013_CUSTLEVE_0);	//新增默认初级
		cust.setPasswdvaliddate(BizFunc.passwordInvalidDate(cust.getUnioncode()));
		String md5Password = cust.getLoginpasswd();
		if(StringUtils.isEmpty(md5Password)) {
			String initPw = ParamConsts.getParam(cust.getUnioncode(), ParamConsts.PARAM2002_PASSWD_INIT);
			md5Password = EncryptUtils.md5Encode(initPw);
		}
		cust.setLoginpasswd(BizFunc.encryptPassword(md5Password, cust.getSalt()));
		custInfoDao.insert(cust);
		
		CustInfoExt custExt = BeanCopyUtils.convert(custReq, CustInfoExt.class);
		custExt.setCustno(cust.getCustno());
		custInfoExtDao.insert(custExt);
		res.success("新增客户成功");
		log.info("新增客户结束 : {}", res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public CustInfoRes update(CustInfoReq custReq) {
		log.info("开始修改客户[custno={}]信息......", custReq.getCustno());
		CustInfoRes res = new CustInfoRes();
		if(!this.check(custReq, res)) {
			return res;
		}
		
		if(uniqueCheckDao.uptExistMobileNo(custReq.getCustno(), custReq.getMobileno()) > 0) {
			res.failure("手机号码[" + custReq.getMobileno() + "]已存在！");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo cust = BeanCopyUtils.convert(custReq, CustInfo.class);
		custInfoDao.dynamicUpdateById(cust);

		CustInfoExt custExt = BeanCopyUtils.convert(custReq, CustInfoExt.class);
		custExt.setCustno(cust.getCustno());
		custInfoExtDao.dynamicUpdateById(custExt);

		res.success("修改成功");
		log.info("修改客户[custno={}]结束: {}", custReq.getCustno(), res.getReturnmsg());
		return res;
	}

	@Override
	public CustInfoRes custDetail(Long custno) {
		log.info("开始查询客户信息[custno={}]信息...", custno);
		CustInfo custInfo = custInfoDao.getById(custno);
		CustInfoRes res = new CustInfoRes();
		if(custInfo == null) {
			res.failure("客户信息不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfoExt custExt = custInfoExtDao.getById(custno);
		BeanCopyUtils.copy(custInfo, res);
		if(custExt != null) {
			BeanCopyUtils.copy(custExt, res);
			res.success();
		}
		log.info("查询客户信息[custno={}]结束: {}", custno, res.getReturnmsg());
		return res;
	}

	@Override
	public CustInfoRes resetPassword(CustInfoReq custInfoReq) {
		log.info("开始重置客户[custno={}]密码......", custInfoReq.getCustno());
		CustInfoRes res = new CustInfoRes();		
		CustInfo cust = custInfoDao.getById(custInfoReq.getCustno());
		if(cust == null) {
			res.failure("客户[" + custInfoReq.getCustno() + "]不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(cust.getStatus())
				&& !DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(cust.getStatus())) {
			res.failure("客户[" + custInfoReq.getCustno() + "]状态异常，不能重置密码");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo updateUser = new CustInfo();
		updateUser.setCustno(custInfoReq.getCustno());
		updateUser.setSalt(BizFunc.createPasswdSalt());
		String md5Password = EncryptUtils.md5Encode(ParamConsts.getParam(cust.getUnioncode(), ParamConsts.PARAM2002_PASSWD_INIT));
		updateUser.setLoginpasswd(BizFunc.encryptPassword(md5Password, updateUser.getSalt()));
		updateUser.setLoginerror(0);
		updateUser.setPasswdvaliddate(BizFunc.passwordInvalidDate(custInfoReq.getUnioncode()));
		if(DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(cust.getStatus())) {
			updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		}
		custInfoDao.dynamicUpdateById(updateUser);
		res.success("重置密码成功");
		log.info("重置客户[custno={}]密码结束: {}", custInfoReq.getCustno(), res.getReturnmsg());
		return res;
	}

	@Override
	public CustInfoRes updatePassword(CustInfoReq custInfoReq) {
		log.info("修改客户[custno={}]密码......", custInfoReq.getCustno());
		CustInfoRes res = new CustInfoRes();
		
		CustInfo cust = custInfoDao.getById(custInfoReq.getCustno());
		if(cust == null) {
			res.failure("客户[" + custInfoReq.getCustno() + "]不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		if(custInfoReq.getLoginpasswd().equals(custInfoReq.getNewpasswd())) {
			res.failure("客户新密码不能与原密码相同");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		String oldPassword = BizFunc.encryptPassword(custInfoReq.getLoginpasswd(), cust.getSalt());
		if(!oldPassword.equals(cust.getLoginpasswd())) {
			res.failure("客户原密码错误，修改密码失败");
			log.warn(res.getReturnmsg());
			return res;
		}

		if(DictConsts.DICT2001_USER_STATUS_FROZEN.equals(cust.getStatus())) {
			res.failure("客户[" + custInfoReq.getCustno() + "]被冻结，不能修改密码");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo updateUser = new CustInfo();
		updateUser.setCustno(custInfoReq.getCustno());
		String newPassword = BizFunc.encryptPassword(custInfoReq.getNewpasswd(), cust.getSalt());
		updateUser.setLoginpasswd(newPassword);
		updateUser.setLoginerror(0);
		updateUser.setPasswdvaliddate(BizFunc.passwordInvalidDate(custInfoReq.getUnioncode()));
		if(DictConsts.DICT2001_USER_STATUS_PASSWDLOCK.equals(cust.getStatus())) {
			updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		}
		custInfoDao.dynamicUpdateById(updateUser);
		
		res.success("修改密码成功");
		log.info("修改客户[custno={}]密码结束: {}", custInfoReq.getCustno(), res.getReturnmsg());
		return res;
	}

	@Override
	public CustInfoRes freeze(CustInfoReq custInfoReq) {
		log.info("开始冻结客户[custno={}]......", custInfoReq.getCustno());
		CustInfoRes res = new CustInfoRes();
		
		CustInfo cust = custInfoDao.getById(custInfoReq.getCustno());
		if(cust == null) {
			res.failure("客户[" + custInfoReq.getCustno() + "]不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_NORMAL.equals(cust.getStatus())) {
			res.failure("客户[" + custInfoReq.getCustno() + "]状态异常，不能冻结");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo updateUser = new CustInfo();
		updateUser.setCustno(custInfoReq.getCustno());
		updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_FROZEN);
		custInfoDao.dynamicUpdateById(updateUser);
		res.success("冻结客户账号成功");
		log.info("冻结客户[custno={}]结束: {}", custInfoReq.getCustno(), res.getReturnmsg());
		return res;
	}

	@Override
	public CustInfoRes unfreeze(CustInfoReq custInfoReq) {
		log.info("开始解冻客户[custno={}]......", custInfoReq.getCustno());
		CustInfoRes res = new CustInfoRes();
		
		CustInfo cust = custInfoDao.getById(custInfoReq.getCustno());
		if(cust == null) {
			res.failure("客户[" + custInfoReq.getCustno() + "]不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		if(!DictConsts.DICT2001_USER_STATUS_FROZEN.equals(cust.getStatus())) {
			res.failure("客户[" + custInfoReq.getCustno() + "]不为冻结状态，不能冻结");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		CustInfo updateUser = new CustInfo();
		updateUser.setCustno(custInfoReq.getCustno());
		updateUser.setStatus(DictConsts.DICT2001_USER_STATUS_NORMAL);
		custInfoDao.dynamicUpdateById(updateUser);
		res.success("解冻客户账号成功");
		log.info("解冻客户[custno={}]结束: {}", custInfoReq.getCustno(), res.getReturnmsg());
		return res;
	}
	
	@Override
	public BaseResListDto<CustInfoRes> pageCustInfo(CustInfoReq custReq) {
		log.info("开始分页查询客户信息，req : {}", custReq.toString());
		Page<CustInfoRes> page = PageHelper.startPage(custReq.getPageNum(), custReq.getPageSize());
		CustInfo where = BeanCopyUtils.convert(custReq, CustInfo.class);
		List<CustInfo> custList = pageQueryDao.findCustList(where);
		List<CustInfoRes> custResList = BeanCopyUtils.convertList(custList, CustInfoRes.class);
		
		BaseResListDto<CustInfoRes> resList = new BaseResListDto<CustInfoRes>();
		resList.setResults(custResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询客户信息结束，共查询到{}条", custList.size());
		return resList;
	}
	
	private boolean check(CustInfoReq custReq, CustInfoRes res) {
		if(StringUtils.isEmpty(custReq.getLoginid())) {
			res.failure("登录名不能为空");
			log.warn(res.getReturnmsg());
			return false;
		}
		
		return true;
	}
}

package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.gurms.system.dao.SysOrgDao;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.SysOrgReq;
import org.oversky.gurms.system.dto.response.SysOrgRes;
import org.oversky.gurms.system.entity.SysOrg;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.ext.dao.UniqueCheckDao;
import org.oversky.gurms.system.ext.dao.UserOrgDao;
import org.oversky.gurms.system.service.SysOrgService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.valid.GSAValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysOrgServiceImpl implements SysOrgService {

	private static final Logger log = LoggerFactory.getLogger(SysOrgServiceImpl.class);

	@Autowired
	private SysOrgDao orgDao;
	
	@Autowired
	private SysUserDao userDao;
	
	@Autowired
	private UniqueCheckDao uniqueDao;
	
	@Autowired
	private UserOrgDao userOrgDao;
	
	@Override
	@GSAValid(type=SysOrgReq.class)
	public SysOrgRes insert(SysOrgReq orgReq) {
		log.info("开始机构新增......");
		SysOrgRes res = new SysOrgRes();
		//orgname 同一父机构下机构名唯一性检查
		SysOrg org = new SysOrg();
		org.setShortname(orgReq.getShortname());
		org.setParentorg(orgReq.getParentorg());
		if(orgDao.count(org) > 0) {
			res.failure("同级机构中机构名称["+orgReq.getShortname()+"]已存在");
			log.warn("新增机构失败 : {}", res.getReturnmsg());
			return res;
		}

		BeanCopyUtils.copy(orgReq, org);
		if(orgDao.insert(org) != 1) {
			res.failure("插入数据库失败");
			log.warn("新增机构失败 : {}", res.getReturnmsg());
			return res;
		}
		
		res.success("新增机构成功");
		log.info("新增机构[orgid={}]结束: {}", org.getOrgid(), res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public SysOrgRes delete(SysOrgReq orgReq) {
		log.info("开始删除机构[orgid={}]信息...", orgReq.getOrgid());
		SysOrgRes res = new SysOrgRes();
		if(ParamConsts.isRootOrg(orgReq.getOrgid())) {
			res.failure("系统根机构不允许删除");
			log.warn("删除机构失败:{}", res.getReturnmsg());
			return res;
		}
		
		SysOrg org = orgDao.getById(orgReq.getOrgid());
		if(org == null) {
			res.failure("机构[orgid={" + orgReq.getOrgid() + "}]不存在");
			log.warn("删除机构失败:{}", res.getReturnmsg());
			return res;
		}

		SysUser operator = userDao.getById(orgReq.getOperator());
		if(operator.getOrgid() == orgReq.getOrgid()) {
			res.failure("不允许删除自己所在机构");
			log.warn("删除机构失败:{}", res.getReturnmsg());
			return res;
		}
		
		//删除的机构是否有子机构
		SysOrg orgCond = new SysOrg();
		orgCond.setParentorg(orgReq.getOrgid());
		boolean hasChild = orgDao.count(orgCond) > 0 ? true : false;
		//删除的机构是否有人员
		SysUser userCond = new SysUser();
		userCond.setOrgid(orgReq.getOrgid());
		boolean hasUser = userDao.count(userCond) > 0 ? true : false;
		String param1006 = ParamConsts.getParam(orgReq.getUnioncode(), ParamConsts.PARAM1006_DELORG_DEALUSER);
		log.info("param 1006 = {}", param1006);
		if(hasUser) {
			if(ParamConsts.PARAM1006_CANT_DEL.equals(param1006)) {
				res.failure("当前机构存在用户，不允许删除");
				log.warn("删除机构失败:{}", res.getReturnmsg());
				return res;
			}
		}
		
		String param1005 = ParamConsts.getParam(orgReq.getUnioncode(), ParamConsts.PARAM1005_DELORG_DEALCHILD);
		log.info("param 1005 = {}", param1005);
		if(hasChild) {
			if(ParamConsts.PARAM1005_MOVE_PARENT.equals(param1005)) {
				if(hasUser && ParamConsts.PARAM1006_MOVE_PARENT.equals(param1006)) {
					this.batchUpdateUserOrgid(org.getOrgid(), org.getParentorg());
				}
				
				SysOrg orgField = new SysOrg();
				orgField.setParentorg(org.getParentorg());
				
				SysOrg orgWhere = new SysOrg();
				orgWhere.setParentorg(org.getOrgid());
				orgDao.dynamicUpdateWhere(orgField, orgWhere);	//更新子机构的父机构ID
				
				orgDao.deleteById(orgReq.getOrgid());
			}else if(ParamConsts.PARAM1005_DEL_CHILDREN.equals(param1005)) {
				List<SysOrg> children = this.getChildOrgs(org.getOrgid());
				int userNum = userOrgDao.countChildOrgUser(children);
				if(ParamConsts.PARAM1006_CANT_DEL.equals(param1006) && userNum > 0) {
					res.failure("子机构存在用户，不允许删除");
					log.warn("删除机构失败:{}", res.getReturnmsg());
					return res;
				}
				
				children.add(org);
				if(ParamConsts.PARAM1006_MOVE_PARENT.equals(param1006) && userNum > 0) {
					userOrgDao.updateUserOrg(org.getParentorg(), children);
				}
				
				userOrgDao.deleteByOrgIds(children);
			}else {
				res.failure("当前机构存在子机构，不允许删除");
				log.warn("删除机构失败:{}", res.getReturnmsg());
				return res;
			}
		}else {
			if(hasUser && ParamConsts.PARAM1006_MOVE_PARENT.equals(param1006)) {
				this.batchUpdateUserOrgid(org.getOrgid(), org.getParentorg());
			}
			orgDao.deleteById(orgReq.getOrgid());
		}
		

		res.success("删除机构成功");
		log.info("删除机构[orgid={}]结束：{}", orgReq.getOrgid(), res.getReturnmsg());
		return res;
	}

	@Override
	public SysOrgRes update(SysOrgReq orgReq) {
		log.info("开始修改机构[orgid={}]信息......", orgReq.getOrgid());
		SysOrgRes res = new SysOrgRes();
		if(ParamConsts.isRootOrg(orgReq.getOrgid())) {
			res.failure("系统根机构不允许修改");
			log.warn("修改机构失败:{}", res.getReturnmsg());
			return res;
		}
		//orgname 同一父机构下机构名唯一性检查，机构名允许修改
		if(uniqueDao.existOrgNameUpdate(orgReq.getOrgid(), orgReq.getShortname(), orgReq.getParentorg()) > 0) {
			res.failure("同级机构中机构名称["+orgReq.getShortname()+"]已存在");
			log.warn("修改机构失败 : {}", res.getReturnmsg());
			return res;
		}
		
		List<SysOrg> children = this.getChildOrgs(orgReq.getOrgid());
		for(SysOrg child : children) {
			if(child.getOrgid() == orgReq.getParentorg()) {
				res.failure("上级机构不能修改为自己的子机构");
				log.warn("修改机构失败 : {}", res.getReturnmsg());
				return res;
			}
		}

		SysOrg org = BeanCopyUtils.convert(orgReq, SysOrg.class);
		orgDao.updateById(org);
		
		res.success("修改机构成功");
		log.info("修改机构[orgid={}]结束: {}", org.getOrgid(), res.getReturnmsg());
		return res;
	}
	
	@Override
	public SysOrgRes getById(Long orgid) {
		log.info("开始查询机构[orgid={}]信息...", orgid);
		SysOrg org = orgDao.getById(orgid);
		SysOrgRes res = new SysOrgRes();
		if(org == null) {
			res.failure("机构不存在");
			log.warn(res.getReturnmsg());
			return res;
		}else {
			BeanCopyUtils.copy(org, res);
		}
		log.info("查询机构[orgid={}]结束: {}", orgid, res.getReturnmsg());
		return res;
	}

	@Override
	public SysOrgRes orgTree(SysOrgReq orgReq) {
		SysUser user = userDao.getById(orgReq.getOperator());
		SysOrg org = orgDao.getById(user.getOrgid());
		SysOrgRes res = BeanCopyUtils.convert(org, SysOrgRes.class);
		this.createOrgTree(res);
		return res;
	}
	
	public List<SysOrg> getChildOrgs(Long parentOrgId) {
		SysOrg where = new SysOrg();
		where.setParentorg(parentOrgId);
		List<SysOrg> list = orgDao.selectWhere(where);
		if(list != null && list.size() > 0) {
			for(SysOrg org : list) {
				List<SysOrg> childList = getChildOrgs(org.getOrgid());
				if(childList !=  null && childList.size() > 0) {
					list.addAll(childList);
				}
			}
		}
		
		return list;
	}

	private void createOrgTree(SysOrgRes parentOrg) {
		SysOrg where = new SysOrg();
		where.setParentorg(parentOrg.getOrgid());
		where.orderByAsc("orgid");
		List<SysOrg> children = orgDao.selectWhere(where);
		if(children != null && children.size() > 0) {
			List<SysOrgRes> resList = BeanCopyUtils.convertList(children, SysOrgRes.class);
			parentOrg.setSubOrgs(resList);
			for(SysOrgRes res : resList) {
				createOrgTree(res);
			}
		}
	}
	
	private void batchUpdateUserOrgid(Long origin, Long current) {
		SysUser usrField = new SysUser();
		usrField.setOrgid(current);
		
		SysUser userWhere = new SysUser();
		userWhere.setOrgid(origin);
		userDao.dynamicUpdateWhere(usrField, userWhere);
	}
	
}

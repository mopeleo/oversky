package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.component.PubDefine;
import org.oversky.gurms.system.dao.SysOrgDao;
import org.oversky.gurms.system.dao.SysUserDao;
import org.oversky.gurms.system.dto.request.SysOrgReq;
import org.oversky.gurms.system.dto.response.SysOrgRes;
import org.oversky.gurms.system.entity.SysOrg;
import org.oversky.gurms.system.entity.SysUser;
import org.oversky.gurms.system.ext.dao.UniqueCheckDao;
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
	
	@Override
	@GSAValid(type=SysOrgReq.class)
	@Transactional
	public SysOrgRes insert(SysOrgReq orgReq) {
		log.info("开始机构新增......");
		SysOrgRes res = new SysOrgRes();
		//orgname 同一父机构下机构名唯一性检查
		if(uniqueDao.existOrgNameInsert(orgReq.getShortname(), orgReq.getParentorg()) > 0) {
			res.failure("同级机构中机构名称["+orgReq.getShortname()+"]已存在");
			log.info("新增机构失败 : {}", res.getReturnmsg());
			return res;
		}

		SysOrg org = BeanCopyUtils.convert(orgReq, SysOrg.class);
		if(orgDao.insert(org) != 1) {
			res.failure("插入数据库失败");
			log.info("新增机构失败 : {}", res.getReturnmsg());
			return res;
		}
		
		res.success("新增机构成功");
		log.info("新增机构[orgid={}]结束: {}", org.getOrgid(), res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public SysOrgRes delete(Long orgid) {
		log.info("开始删除机构[orgid={}]信息...", orgid);
		SysOrgRes res = new SysOrgRes();
		if(PubDefine.isRootOrg(orgid)) {
			res.failure("系统根机构不允许删除");
			log.info("删除机构失败:{}", res.getReturnmsg());
			return res;
		}
		if(orgDao.deleteById(orgid) > 1) {
			log.info("删除机构[orgid={}]失败：机构信息不唯一", orgid);
			throw new BaseServiceException("删除机构[orgid=" + orgid + "]失败：机构信息不唯一");
		}

		res.success("删除机构成功");
		log.info("删除机构[orgid={}]结束：{}", orgid, res.getReturnmsg());
		return res;
	}

	@Override
	@Transactional
	public SysOrgRes update(SysOrgReq orgReq) {
		log.info("开始修改机构[orgid={}]信息......", orgReq.getOrgid());
		SysOrgRes res = new SysOrgRes();
		if(PubDefine.isRootOrg(orgReq.getOrgid())) {
			res.failure("系统根机构不允许修改");
			log.info("修改机构失败:{}", res.getReturnmsg());
			return res;
		}
		//orgname 同一父机构下机构名唯一性检查，机构名允许修改
		if(uniqueDao.existOrgNameUpdate(orgReq.getShortname(), orgReq.getOrgid(), orgReq.getParentorg()) > 0) {
			res.failure("同级机构中机构名称["+orgReq.getShortname()+"]已存在");
			log.info("修改机构失败 : {}", res.getReturnmsg());
			return res;
		}

		SysOrg org = BeanCopyUtils.convert(orgReq, SysOrg.class);
		if(orgDao.updateById(org) > 1) {
			log.info("更新机构[orgid={}]失败：机构信息不唯一", org.getOrgid());
			throw new BaseServiceException("更新机构[orgid=" + org.getOrgid() + "]失败：机构信息不唯一");
		}
		
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
}

package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.dto.request.SysParamReq;
import org.oversky.gurms.system.dto.response.SysParamInfoRes;
import org.oversky.gurms.system.dto.response.SysParamRes;
import org.oversky.gurms.system.entity.SysParam;
import org.oversky.gurms.system.entity.SysParamInfo;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
import org.oversky.gurms.system.service.SysParamService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class SysParamServiceImpl implements SysParamService {

	private static final Logger log = LoggerFactory.getLogger(SysParamServiceImpl.class);
	
	@Autowired
	private SysParamDao paramDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;
	
	public String getSysMode() {
		SysParam param = paramDao.getById(ParamConsts.DEFAULT_UNIONCODE, ParamConsts.PARAM1000_SYS_MODE);
		if(param == null) {
			log.error("系统模式参数不存在，paramId = {}", ParamConsts.PARAM1000_SYS_MODE);
			throw new BaseServiceException("系统模式参数不存在");
		}
		
		String sysMode = param.getParamvalue();
		if(!ParamConsts.PARAM1000_SYS_MODE_SINGLE.equals(sysMode) && !ParamConsts.PARAM1000_SYS_MODE_MULTI.equals(sysMode)) {			
			log.error("系统模式参数值配置错误，paramValue = {}", sysMode);
			throw new BaseServiceException("系统模式参数值配置错误");
		}
		return sysMode;
	}
	
	@Override
	public SysParamRes getParam(String unioncode, Integer paramId) {
		log.info("查询单个参数 : unioncode = {}, paramId = {}" , unioncode, paramId);
		SysParam param = paramDao.getById(unioncode, paramId);
		//参数为空，且unioncode不是0000，且是多法人模式，再去查一次
		if(param == null && !ParamConsts.isRootUnioncode(unioncode) && ParamConsts.isMultiLegal()) {
			param = paramDao.getById(ParamConsts.DEFAULT_UNIONCODE, paramId);
		}

		if(param == null) {
			log.error("系统参数不存在，paramId = {}", paramId);
			throw new BaseServiceException("错误的系统参数 : " + paramId);
		}			
		return BeanCopyUtils.convert(param, SysParamRes.class);
	}

	@Override
	public BaseResListDto<SysParamRes> getParamList(String unioncode, String paramList) {
		log.info("查询多个参数 : unioncode = {}, paramList = {}" , unioncode, paramList);
		String[] idList = paramList.split(",");
		BaseResListDto<SysParamRes> res = new BaseResListDto<SysParamRes>();
		List<SysParamRes> results = new ArrayList<>(idList.length);
		for(String paramId : idList) {
			SysParamRes param = this.getParam(unioncode, Integer.parseInt(paramId));
			results.add(param);
		}
		
		res.setResults(results);
		log.info("查询成功");
		return res;
	}

	@Override
	@Transactional
	public SysParamRes reset(String unioncode) {
		log.info("重置unioncode = {}参数" , unioncode);
		SysParamRes res = new SysParamRes();
		List<SysParamInfo> paramInfoList = pageQueryDao.findParams(unioncode);
		if(CollectionUtils.isEmpty(paramInfoList)) {
			res.failure("参数不存在");
			log.warn(res.getReturnmsg());
			return res;
		}

		SysParam where = new SysParam();
		where.setUnioncode(unioncode);
		int num = paramDao.deleteWhere(where);
		
		if(num != paramInfoList.size()) {
			log.error("重置unioncode = {}参数 : 数量不一致" , unioncode);
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<SysParam> paramList = new ArrayList<>(paramInfoList.size());
		for(SysParamInfo paramInfo : paramInfoList) {
			SysParam param = new SysParam();
			param.setUnioncode(unioncode);
			param.setParamid(paramInfo.getParamid());
			param.setParamvalue(paramInfo.getInitvalue());
			
			paramList.add(param);
		}
		paramDao.insertBatch(paramList);
		
		log.info("重置unioncode = {}参数 : [{}] 条" , unioncode, num);
		return res;
	}

	@Override
	public BaseResListDto<SysParamInfoRes> paramInfoPage(String unioncode) {
		BaseResListDto<SysParamInfoRes> res = new BaseResListDto<SysParamInfoRes>();
		List<SysParamInfo> paramInfoList = pageQueryDao.findParams(unioncode);
		if(CollectionUtils.isEmpty(paramInfoList)) {
			res.failure("参数不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		SysParam where = new SysParam();
		where.setUnioncode(unioncode);
		where.orderBy("paramid");
		List<SysParam> paramList = paramDao.selectWhere(where);
		if(paramList.size() != paramInfoList.size()) {
			log.error("重置unioncode = {}参数 : 数量不一致" , unioncode);
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<SysParamInfoRes> results = BeanCopyUtils.convertList(paramInfoList, SysParamInfoRes.class);
		for(int i = 0; i < results.size(); i++) {
			results.get(i).setValue(paramList.get(i).getParamvalue());
		}
		
		res.setResults(results);
		return res;
	}

	// paramList =  key1:value1;key2:value2
	@Override
	@Transactional
	public SysParamRes update(SysParamReq paramReq) {
		log.info("修改unioncode = {}全部参数" , paramReq.getUnioncode());
		SysParamRes res = new SysParamRes();
		if(StringUtils.isEmpty(paramReq.getParamlist())) {
			log.error("修改的参数列表不能为空");
			throw new BaseServiceException("修改的参数列表不能为空");
		}
		
		SysParam where = new SysParam();
		where.setUnioncode(paramReq.getUnioncode());
		int num = paramDao.deleteWhere(where);
		
		String[] pairs = paramReq.getParamlist().split(";");
		if(pairs.length != num) {
			log.error("修改unioncode = {}参数 : 数量不一致" , paramReq.getUnioncode());
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<SysParam> sysParamList = new ArrayList<>(num);
		for(String param : pairs) {
			String[] keyvalue = param.split(":");
			SysParam sysParam = new SysParam();
			sysParam.setParamid(Integer.parseInt(keyvalue[0]));
			sysParam.setParamvalue(keyvalue[1]);
			sysParam.setUnioncode(paramReq.getUnioncode());
			
			sysParamList.add(sysParam);
		}
		
		paramDao.insertBatch(sysParamList);
		log.info("修改unioncode = {}全部参数成功" , paramReq.getUnioncode());
		return res;		
	}
}

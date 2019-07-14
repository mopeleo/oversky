package org.oversky.gurms.system.service.impl;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.dto.response.SysParamRes;
import org.oversky.gurms.system.entity.SysParam;
import org.oversky.gurms.system.service.SysParamService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "SysParam")
public class SysParamServiceImpl implements SysParamService {

	private static final Logger log = LoggerFactory.getLogger(SysParamServiceImpl.class);
	
	@Autowired
	private SysParamDao paramDao;
	
	@Override
	@Cacheable(key = "'getParam_' + #p0 + '_' + #p1")
	public SysParamRes getParam(String unioncode, Integer paramId) {
		log.info("查询单个参数 : unioncode = {}, paramId = {}" , unioncode, paramId);
		SysParam param = paramDao.getById(unioncode, paramId);
		return BeanCopyUtils.convert(param, SysParamRes.class);
	}

	@Override
	@Cacheable(key = "'getParamList_' + #p0 + '_' + #p1")
	public BaseResListDto<SysParamRes> getParamList(String unioncode, String paramList) {
		log.info("查询多个参数 : unioncode = {}, paramList = {}" , unioncode, paramList);
		String[] idList = paramList.split(",");

		return null;
	}

}

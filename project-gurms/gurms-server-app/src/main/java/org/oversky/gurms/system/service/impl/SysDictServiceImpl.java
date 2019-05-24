package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.gurms.system.dao.SysDictIndexDao;
import org.oversky.gurms.system.dao.SysDictValueDao;
import org.oversky.gurms.system.dto.response.SysDictValueRes;
import org.oversky.gurms.system.entity.SysDictValue;
import org.oversky.gurms.system.service.SysDictService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "SysDictValue")
public class SysDictServiceImpl implements SysDictService {

	private static final Logger log = LoggerFactory.getLogger(SysDictServiceImpl.class);
	
	@Autowired
	private SysDictValueDao dictValueDao;
	
	@Autowired
	private SysDictIndexDao dictIndexDao;
	
	@Override
	@Cacheable(key = "'getDictList_' + #p0 + '_' + #p1")
	public BaseResListDto<SysDictValueRes> getDictList(String unioncode, Integer dictcode) {
		log.info("查询单个字典 : dictcode = {}" + dictcode);
		SysDictValue where = new SysDictValue();
		where.setUnioncode(unioncode);
		where.setDictcode(dictcode);
		List<SysDictValue> list = dictValueDao.selectWhere(where);
		List<SysDictValueRes> dictResList = BeanCopyUtils.convertList(list, SysDictValueRes.class);
		
		BaseResListDto<SysDictValueRes> resList = new BaseResListDto<>();
		resList.setResults(dictResList);
		resList.success("查询成功");
		return resList;
	}

	@Override
	@Cacheable(key = "'getDictMap_' + #p0 + '_' + #p1")
	public BaseResMapDto<String, List<SysDictValueRes>> getDictMap(String unioncode, String dictcodeList) {
		log.info("查询多个字典 : dictcode = {}" + dictcodeList);
		String[] codeList = dictcodeList.split(",");
		BaseResMapDto<String, List<SysDictValueRes>> dictMap = new BaseResMapDto<>();
		for(String dictcode : codeList) {
			List<SysDictValueRes> roleResList = getDictList(unioncode, Integer.parseInt(dictcode)).getResults();
			dictMap.putMap(dictcode, roleResList);
		}
		
		dictMap.success("查询成功");
		return dictMap;
	}

}

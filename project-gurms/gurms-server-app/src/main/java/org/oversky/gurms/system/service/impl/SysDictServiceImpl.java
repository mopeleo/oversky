package org.oversky.gurms.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseResMapDto;
import org.oversky.gurms.system.constant.ParamConsts;
import org.oversky.gurms.system.dao.SysDictIndexDao;
import org.oversky.gurms.system.dao.SysDictValueDao;
import org.oversky.gurms.system.dao.SysOrgDao;
import org.oversky.gurms.system.dto.request.SysDictReq;
import org.oversky.gurms.system.dto.response.SysDictRes;
import org.oversky.gurms.system.entity.SysDictValue;
import org.oversky.gurms.system.entity.SysOrg;
import org.oversky.gurms.system.ext.bo.SysDictBO;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
import org.oversky.gurms.system.service.SysDictService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@CacheConfig(cacheNames = "SysDictValue")
public class SysDictServiceImpl implements SysDictService {

	private static final Logger log = LoggerFactory.getLogger(SysDictServiceImpl.class);
	
	@Autowired
	private SysDictValueDao dictValueDao;
	
	@Autowired
	private SysDictIndexDao dictIndexDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;

	@Autowired
	private SysOrgDao orgDao;

	@Override
	@Cacheable(key = "'getDictList_' + #p0 + '_' + #p1")
	public BaseResListDto<SysDictRes> getDictList(String unioncode, Integer dictcode) {
		log.info("查询单个字典 : dictcode = {}", dictcode);
		SysDictValue where = new SysDictValue();
		where.setUnioncode(unioncode);
		where.setDictcode(dictcode);
		List<SysDictValue> list = dictValueDao.selectWhere(where);
		if(CollectionUtils.isEmpty(list) && !ParamConsts.isRootUnioncode(unioncode) && ParamConsts.isMultiLegal()) {
			where.setUnioncode(ParamConsts.DEFAULT_UNIONCODE);
			list = dictValueDao.selectWhere(where);
		}
		List<SysDictRes> dictResList = BeanCopyUtils.convertList(list, SysDictRes.class);
		
		BaseResListDto<SysDictRes> resList = new BaseResListDto<>();
		resList.setResults(dictResList);
		resList.success("查询成功");
		return resList;
	}

	@Override
	@Cacheable(key = "'getDictMap_' + #p0 + '_' + #p1")
	public BaseResMapDto<String, List<SysDictRes>> getDictMap(String unioncode, String dictcodeList) {
		log.info("查询多个字典 : dictcode = {}", dictcodeList);
		String[] codeList = dictcodeList.split(",");
		BaseResMapDto<String, List<SysDictRes>> dictMap = new BaseResMapDto<>();
		for(String dictcode : codeList) {
			List<SysDictRes> roleResList = getDictList(unioncode, Integer.parseInt(dictcode)).getResults();
			dictMap.putMap(dictcode, roleResList);
		}
		
		dictMap.success("查询成功");
		return dictMap;
	}

	@Override
	public BaseResListDto<SysDictRes> pageSysDict(SysDictReq dictReq) {
		log.info("开始分页查询数据字典...");
		Page<SysDictBO> page = PageHelper.startPage(dictReq.getPageNum(), dictReq.getPageSize());
		SysDictBO where = BeanCopyUtils.convert(dictReq, SysDictBO.class);
		if(ParamConsts.isRootUnioncode(where.getUnioncode())) {
			where.setUnioncode(null);
		}
		List<SysDictBO> dictList = pageQueryDao.findDicts(where);
		List<SysDictRes> roleResList = BeanCopyUtils.convertList(dictList, SysDictRes.class);
		
		BaseResListDto<SysDictRes> resList = new BaseResListDto<SysDictRes>();
		resList.setResults(roleResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询数据字典结束，共查询到{}条", dictList.size());
		return resList;
	}

	public BaseResListDto<SysDictRes> getSpecialDict(Map<String, String> req) {
		String type = req.get("type");
		log.info("查询特殊字典 : type = {}", type);
		BaseResListDto<SysDictRes> resList = new BaseResListDto<>();
		List<SysDictRes> dictResList = null;
		switch(type) {
			case "T01":
				log.info("转换机构[sys_org]信息为字典");
				SysOrg where = new SysOrg();
				String unioncode = req.get("unioncode");
				if(!ParamConsts.isRootUnioncode(unioncode)) {
					where.setUnioncode(unioncode);
				}
				List<SysOrg> orgList = orgDao.selectWhere(where);
				if(CollectionUtils.isEmpty(orgList)) {
					break;
				}
				dictResList = new ArrayList<>(orgList.size());
				for(SysOrg org : orgList) {
					SysDictRes res = new SysDictRes();
					res.setItemcode(org.getOrgid().toString());
					res.setItemname(org.getShortname());
					
					dictResList.add(res);
				}
				break;
			default:
				log.warn("错误的字典类型 : type = {}", type);
				break;
		}
		
		resList.setResults(dictResList);
		resList.success("查询成功");
		return resList;
	}

}

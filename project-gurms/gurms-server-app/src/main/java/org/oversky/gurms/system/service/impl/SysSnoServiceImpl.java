package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.dao.SysSnoDao;
import org.oversky.gurms.system.dto.request.SysSnoReq;
import org.oversky.gurms.system.dto.response.SysSnoRes;
import org.oversky.gurms.system.entity.SysSno;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
import org.oversky.gurms.system.service.SysSnoService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysSnoServiceImpl implements SysSnoService {

	private static final Logger log = LoggerFactory.getLogger(SysSnoServiceImpl.class);

	@Autowired
	private SysSnoDao snoDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;
	
	@Override
	public SysSnoRes getById(String unioncode, Integer snoid) {
		log.info("开始查询序列[unioncode={}, snoid={}]信息...", unioncode, snoid);
		SysSno sno = snoDao.getById(unioncode, snoid);
		SysSnoRes res = new SysSnoRes();
		if(sno == null) {
			res.failure("序列不存在");
		}else {
			BeanCopyUtils.copy(sno, res);
		}
		log.info("查询序列[unioncode={}, snoid={}]结束: {}", unioncode, snoid, res.getReturnmsg());
		return res;
	}

	@Override
	public SysSnoRes update(SysSnoReq snoReq) {
		log.info("开始修改序列[unioncode={}, snoid={}]信息......", snoReq.getUnioncode(), snoReq.getNoid());
		SysSnoRes res = new SysSnoRes();
		SysSno sno = BeanCopyUtils.convert(snoReq, SysSno.class);
		snoDao.updateById(sno);
		
		res.success("修改序列成功");
		log.info("修改序列[unioncode={}, snoid={}]结束: {}", snoReq.getUnioncode(), sno.getNoid(), res.getReturnmsg());
		return res;
	}

	@Override
	public BaseResListDto<SysSnoRes> pageSysSno(SysSnoReq snoReq) {
		log.info("开始分页查询角色信息...");
		Page<SysSno> page = PageHelper.startPage(snoReq.getPageNum(), snoReq.getPageSize());
		SysSno where = BeanCopyUtils.convert(snoReq, SysSno.class);
		List<SysSno> snoList = pageQueryDao.findSnos(where);
		List<SysSnoRes> snoResList = BeanCopyUtils.convertList(snoList, SysSnoRes.class);
		
		BaseResListDto<SysSnoRes> resList = new BaseResListDto<SysSnoRes>();
		resList.setResults(snoResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询角色信息结束，共查询到{}条", snoList.size());
		return resList;
	}

}

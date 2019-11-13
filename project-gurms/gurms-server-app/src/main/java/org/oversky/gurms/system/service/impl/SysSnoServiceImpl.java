package org.oversky.gurms.system.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.gurms.system.constant.DictConsts;
import org.oversky.gurms.system.dao.SysSnoDao;
import org.oversky.gurms.system.dto.request.SysSnoReq;
import org.oversky.gurms.system.dto.response.SysSnoRes;
import org.oversky.gurms.system.entity.SysSno;
import org.oversky.gurms.system.ext.dao.PageListQueryDao;
import org.oversky.gurms.system.service.SysSnoService;
import org.oversky.util.bean.BeanCopyUtils;
import org.oversky.util.date.DateUtils;
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
			log.warn(res.getReturnmsg());
			return res;
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
		log.info("开始分页查询序列信息...");
		Page<SysSno> page = PageHelper.startPage(snoReq.getPageNum(), snoReq.getPageSize());
		SysSno where = BeanCopyUtils.convert(snoReq, SysSno.class);
		List<SysSno> snoList = pageQueryDao.findSnos(where);
		List<SysSnoRes> snoResList = BeanCopyUtils.convertList(snoList, SysSnoRes.class);
		
		BaseResListDto<SysSnoRes> resList = new BaseResListDto<SysSnoRes>();
		resList.setResults(snoResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询序列信息结束，共查询到{}条", snoList.size());
		return resList;
	}

	public synchronized String getNextSno(String unioncode, Integer snoid) {
		log.info("开始获取序列[unioncode={}, snoid={}]的序列号......", unioncode, snoid);
		SysSno sno = snoDao.getById(unioncode, snoid);		
		String formatSno = this.formatSno(sno);
		
		this.cycleSno(sno);
		snoDao.updateById(sno);
		
		log.info("获取序列[unioncode={}, snoid={}]的序列号为[{}]", unioncode, snoid, formatSno);
		return formatSno;
	}
	
	public synchronized String[] getBatchSno(String unioncode, Integer snoid, Integer number) {
		log.info("开始获取序列[unioncode={}, snoid={}]批量[{}]个序列号......", unioncode, snoid, number);
		SysSno sno = snoDao.getById(unioncode, snoid);		
		log.info("批量获取序列前，最新序列为[{}]", sno.getNextvalue());
		
		String[] batchs = new String[number];
		for(int i = 0; i < number; i++) {
			String formatSno = this.formatSno(sno);			
			batchs[i] = formatSno;
			
			this.cycleSno(sno);
		}
		
		snoDao.updateById(sno);		
		log.info("批量获取[{}]个序列后，最新序列为[{}]", number, sno.getNextvalue());
		return batchs;
	}
	
	private void cycleSno(SysSno sno) {
		Long currentVal = sno.getNextvalue();
		Long nextVal = 0L;
		String now = DateUtils.getNowDate();
		switch(sno.getCycletype()) {
			case DictConsts.DICT1015_RESET_VALUE:
				if(currentVal == sno.getEndvalue()) {
					nextVal = sno.getInitvalue();
				}else {
					if(DictConsts.DICT1016_INCREASE.equals(sno.getNotype())) {
						nextVal = currentVal + 1;
					}else if(DictConsts.DICT1016_DECREASE.equals(sno.getNotype())) {
						nextVal = currentVal - 1;
					}
				}
				break;
			case DictConsts.DICT1015_RESET_DAY:
				if(!now.equals(sno.getCycledate())) {
					nextVal = sno.getInitvalue();
					sno.setCycledate(now);
				}else {
					if(DictConsts.DICT1016_INCREASE.equals(sno.getNotype())) {
						nextVal = currentVal + 1;
					}else if(DictConsts.DICT1016_DECREASE.equals(sno.getNotype())) {
						nextVal = currentVal - 1;
					}
				}
				break;
			case DictConsts.DICT1015_RESET_MONTH:
				String cycleMonth = DateUtils.addMonths(sno.getCycledate(), 1);
				if(now.compareTo(cycleMonth) >= 0) {
					nextVal = sno.getInitvalue();
					sno.setCycledate(cycleMonth);
				}else {
					if(DictConsts.DICT1016_INCREASE.equals(sno.getNotype())) {
						nextVal = currentVal + 1;
					}else if(DictConsts.DICT1016_DECREASE.equals(sno.getNotype())) {
						nextVal = currentVal - 1;
					}
				}
				break;
			case DictConsts.DICT1015_RESET_YEAR:
				String cycleYear = DateUtils.addYears(sno.getCycledate(), 1);
				if(now.compareTo(cycleYear) >= 0) {
					nextVal = sno.getInitvalue();
					sno.setCycledate(cycleYear);
				}else {
					if(DictConsts.DICT1016_INCREASE.equals(sno.getNotype())) {
						nextVal = currentVal + 1;
					}else if(DictConsts.DICT1016_DECREASE.equals(sno.getNotype())) {
						nextVal = currentVal - 1;
					}
				}
				break;
			default:
				break;
		}
		sno.setNextvalue(nextVal);
	}
	
	private String formatSno(SysSno sno) {		
		//格式化
		String formatSno = Long.toString(sno.getNextvalue());
		if(DictConsts.DICT1014_FIXED.equals(sno.getFixedflag())) {
			if(formatSno.length() < sno.getFixedlength()) {
				String fmt = "%" + sno.getFillchar() + sno.getFixedlength().toString() + "d";
				formatSno = String.format(fmt, sno.getNextvalue());
			}
		}
		if(StringUtils.isNotEmpty(sno.getPrefix())) {
			formatSno = sno.getPrefix() + formatSno;
		}
		if(StringUtils.isNotEmpty(sno.getSuffix())) {
			formatSno = formatSno + sno.getSuffix();
		}
		
		if(formatSno.toLowerCase().indexOf("{date}") >= 0) {
			String date = DateUtils.getNowDate();
			formatSno = formatSno.replaceAll("\\{date\\}", date);
		}
		
		if(formatSno.toLowerCase().indexOf("{time}") >= 0) {
			String time = DateUtils.getNowTime();
			formatSno = formatSno.replaceAll("\\{time\\}", time);
		}
		
		log.info("格式化后的序列号为：{}", formatSno);
		return formatSno;
	}
}

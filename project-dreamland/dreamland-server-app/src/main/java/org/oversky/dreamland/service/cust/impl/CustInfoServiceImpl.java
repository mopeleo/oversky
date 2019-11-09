package org.oversky.dreamland.service.cust.impl;

import java.util.List;

import org.oversky.base.service.BaseResListDto;
import org.oversky.dreamland.dao.cust.CustInfoDao;
import org.oversky.dreamland.dto.request.cust.CustInfoReq;
import org.oversky.dreamland.dto.response.cust.CustInfoRes;
import org.oversky.dreamland.entity.cust.CustInfo;
import org.oversky.dreamland.ext.dao.PageListQueryDao;
import org.oversky.dreamland.service.cust.CustInfoService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CustInfoServiceImpl implements CustInfoService {
    private static Logger log = LoggerFactory.getLogger(CustInfoServiceImpl.class);

    @Autowired
    private CustInfoDao custInfoDao;
	@Autowired
	private PageListQueryDao pageQueryDao;

	@Override
	public CustInfoRes login(CustInfoReq req) {
		log.info("用户登录，req : {}", req.toString());
		CustInfoRes res = new CustInfoRes();
		res.success("登录成功");
		return res;
	}

	public CustInfoRes custDetail(Long custno) {
		log.info("开始查询客户信息[custno={}]信息...", custno);
		CustInfo custInfo = custInfoDao.getById(custno);
		CustInfoRes res = new CustInfoRes();
		if(custInfo == null) {
			res.failure("客户信息不存在");
		}else {
			BeanCopyUtils.copy(custInfo, res);
		}
		log.info("查询客户信息[custno={}]结束: {}", custno, res.getReturnmsg());
		return res;
	}
	
	public BaseResListDto<CustInfoRes> pageCustInfo(CustInfoReq custReq) {
		log.info("开始分页查询客户信息，req : {}", custReq.toString());
		Page<CustInfoRes> page = PageHelper.startPage(custReq.getPageNum(), custReq.getPageSize());
		CustInfo where = BeanCopyUtils.convert(custReq, CustInfo.class);
		List<CustInfo> custList = pageQueryDao.findCusts(where);
		List<CustInfoRes> custResList = BeanCopyUtils.convertList(custList, CustInfoRes.class);
		
		BaseResListDto<CustInfoRes> resList = new BaseResListDto<CustInfoRes>();
		resList.setResults(custResList);
		resList.success("查询成功");
		resList.initPage(page.getPageNum(), page.getPageSize(), (int)page.getTotal());
		log.info("分页查询客户信息结束，共查询到{}条", custList.size());
		return resList;
	}
}

package org.oversky.dreamland.service.impl.com;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oversky.base.service.BaseResListDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.dreamland.dao.com.ComParamDao;
import org.oversky.dreamland.dto.request.com.ComParamReq;
import org.oversky.dreamland.dto.response.com.ComParamInfoRes;
import org.oversky.dreamland.dto.response.com.ComParamRes;
import org.oversky.dreamland.entity.com.ComParam;
import org.oversky.dreamland.entity.com.ComParamInfo;
import org.oversky.dreamland.ext.dao.PageListQueryDao;
import org.oversky.dreamland.service.com.ComParamService;
import org.oversky.util.bean.BeanCopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ComParamServiceImpl implements ComParamService {

	private static final Logger log = LoggerFactory.getLogger(ComParamServiceImpl.class);
	
	@Autowired
	private ComParamDao paramDao;
	
	@Autowired
	private PageListQueryDao pageQueryDao;
	
	@Override
	public ComParamRes getParam(String unioncode, Integer paramId) {
		log.info("查询单个参数 : unioncode = {}, paramId = {}" , unioncode, paramId);
		ComParam param = paramDao.getById(unioncode, paramId);
		if(param == null) {
			log.error("系统参数不存在，paramId = {}", paramId);
			throw new BaseServiceException("错误的系统参数 : " + paramId);
		}
		
		ComParamRes res = new ComParamRes();
		BeanCopyUtils.copy(param, res);
		res.success();
		
		log.info("查询单个参数 : unioncode = {}, paramId = {}成功" , unioncode, paramId);
		return res;
	}

	@Override
	public BaseResListDto<ComParamRes> getParamList(String unioncode, String paramList) {
		log.info("查询多个参数 : unioncode = {}, paramList = {}" , unioncode, paramList);
		String[] idList = paramList.split(",");
		BaseResListDto<ComParamRes> res = new BaseResListDto<ComParamRes>();
		List<ComParamRes> results = new ArrayList<>(idList.length);
		for(String paramId : idList) {
			ComParamRes param = this.getParam(unioncode, Integer.parseInt(paramId));
			results.add(param);
		}
		
		res.setResults(results);
		log.info("查询成功");
		return res;
	}

	@Override
	@Transactional
	public ComParamRes reset(String unioncode) {
		log.info("重置unioncode = {}参数" , unioncode);
		ComParamRes res = new ComParamRes();
		List<ComParamInfo> paramInfoList = pageQueryDao.findParams(unioncode);
		if(CollectionUtils.isEmpty(paramInfoList)) {
			res.failure("参数不存在");
			log.warn(res.getReturnmsg());
			return res;
		}

		ComParam where = new ComParam();
		where.setUnioncode(unioncode);
		int num = paramDao.deleteWhere(where);
		
		if(num != paramInfoList.size()) {
			log.error("重置unioncode = {}参数 : 数量不一致" , unioncode);
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<ComParam> paramList = new ArrayList<>(paramInfoList.size());
		for(ComParamInfo paramInfo : paramInfoList) {
			ComParam param = new ComParam();
			param.setUnioncode(unioncode);
			param.setParamid(paramInfo.getParamid());
			param.setParamvalue(paramInfo.getInitvalue());
			
			paramList.add(param);
		}
		paramDao.insertBatch(paramList);
		
		res.success("恢复出厂设置成功");
		log.info("重置unioncode = {}参数 : [{}] 条" , unioncode, num);
		return res;
	}

	@Override
	public BaseResListDto<ComParamInfoRes> paramInfoPage(String unioncode) {
		BaseResListDto<ComParamInfoRes> res = new BaseResListDto<ComParamInfoRes>();
		List<ComParamInfo> paramInfoList = pageQueryDao.findParams(unioncode);
		if(CollectionUtils.isEmpty(paramInfoList)) {
			res.failure("参数不存在");
			log.warn(res.getReturnmsg());
			return res;
		}
		
		ComParam where = new ComParam();
		where.setUnioncode(unioncode);
		where.orderBy("paramid");
		List<ComParam> paramList = paramDao.selectWhere(where);
		if(paramList.size() != paramInfoList.size()) {
			log.error("重置unioncode = {}参数 : 数量不一致" , unioncode);
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<ComParamInfoRes> results = BeanCopyUtils.convertList(paramInfoList, ComParamInfoRes.class);
		for(int i = 0; i < results.size(); i++) {
			results.get(i).setValue(paramList.get(i).getParamvalue());
		}
		
		res.setResults(results);
		return res;
	}

	// paramList =  key1:value1;key2:value2
	@Override
	@Transactional
	public ComParamRes update(ComParamReq paramReq) {
		log.info("修改unioncode = {}全部参数" , paramReq.getUnioncode());
		ComParamRes res = new ComParamRes();
		if(StringUtils.isEmpty(paramReq.getParamlist())) {
			log.error("修改的参数列表不能为空");
			throw new BaseServiceException("修改的参数列表不能为空");
		}
		
		ComParam where = new ComParam();
		where.setUnioncode(paramReq.getUnioncode());
		int num = paramDao.deleteWhere(where);
		
		String[] pairs = paramReq.getParamlist().split(";");
		if(pairs.length != num) {
			log.error("修改unioncode = {}参数 : 数量不一致" , paramReq.getUnioncode());
			throw new BaseServiceException("参数重置错误:数量不一致");
		}
		
		List<ComParam> sysParamList = new ArrayList<>(num);
		for(String param : pairs) {
			String[] keyvalue = param.split(":");
			ComParam sysParam = new ComParam();
			sysParam.setParamid(Integer.parseInt(keyvalue[0]));
			sysParam.setParamvalue(keyvalue[1]);
			sysParam.setUnioncode(paramReq.getUnioncode());
			
			sysParamList.add(sysParam);
		}
		
		paramDao.insertBatch(sysParamList);
		log.info("修改unioncode = {}全部参数成功" , paramReq.getUnioncode());
		res.success("修改参数成功");
		return res;		
	}
}

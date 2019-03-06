package org.oversky.gurms.system.runner;

import java.util.List;

import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.constant.CacheConsts;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.entity.SysParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // 执行顺序，越小优先级越高
public class CacheSysParamRunner implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(CacheSysParamRunner.class);

	@Autowired
	private SysParamDao paramDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<SysParam> list = paramDao.selectAll();
		if(list == null || list.size() == 0) {
			logger.error("参数初始化失败：加载数为空" );
			throw new BaseServiceException("参数初始化失败");
		}
		
		list.forEach(param->{
			CacheConsts.put(param.getParamid(), param.getUnioncode(), param.getParamvalue());
		});
	}

}

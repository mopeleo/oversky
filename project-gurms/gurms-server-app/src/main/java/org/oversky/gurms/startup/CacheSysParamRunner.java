package org.oversky.gurms.startup;

import java.util.List;

import org.oversky.base.service.BaseServiceException;
import org.oversky.gurms.system.constant.ConfigConsts;
import org.oversky.gurms.system.dao.SysDictIndexDao;
import org.oversky.gurms.system.dao.SysParamDao;
import org.oversky.gurms.system.entity.SysDictIndex;
import org.oversky.gurms.system.entity.SysParam;
import org.oversky.gurms.system.service.SysDictService;
import org.oversky.gurms.system.service.SysMenuService;
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
	
	@Autowired
	private SysDictIndexDao dictIndexDao;
	
	@Autowired
	private SysDictService dictService;
	
	@Autowired
	private SysMenuService menuService;
	
	@Autowired
	private ConfigConsts config;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("gurms.config.redis-enable : [{}]", config.isRedisEnable());

		List<SysParam> paramList = paramDao.selectAll();
		if(paramList == null || paramList.size() == 0) {
			logger.error("参数初始化失败：加载数为空" );
			throw new BaseServiceException("参数初始化失败");
		}		
		paramList.forEach(param->{
			paramDao.getById(param.getUnioncode(), param.getParamid());
		});
		
		List<SysDictIndex> dictList = dictIndexDao.selectAll();
		for(SysDictIndex dictIndex : dictList) {
			dictService.getDictList(dictIndex.getUnioncode(), dictIndex.getDictcode());
		}

		menuService.getFullMenuTree();
	}

}

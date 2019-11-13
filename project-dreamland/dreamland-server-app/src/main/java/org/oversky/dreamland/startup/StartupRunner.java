package org.oversky.dreamland.startup;

import java.util.List;

import org.oversky.dreamland.dao.com.ComDictDao;
import org.oversky.dreamland.entity.com.ComDict;
import org.oversky.dreamland.service.com.ComDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // 执行顺序，越小优先级越高
public class StartupRunner implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

	@Autowired
	private ComDictDao dictDao;
	
	@Autowired
	private ComDictService dictService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("参数初始化开始......");

		
//		List<ComDict> dictList = dictDao.selectAll();
//		for(ComDict dict : dictList) {
//			dictService.getDictList(dict.getDictcode());
//		}

		logger.info("参数初始化启动加载完毕");
	}

}

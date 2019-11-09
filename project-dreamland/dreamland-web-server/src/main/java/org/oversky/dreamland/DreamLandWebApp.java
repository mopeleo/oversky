package org.oversky.dreamland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"org.oversky.dreamland.dao.*","org.oversky.dreamland.ext.dao"})
@ComponentScan(basePackages = {"org.oversky.dreamland","org.oversky.common"})
@EnableTransactionManagement 		// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class DreamLandWebApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(DreamLandWebApp.class, args);
	}

}

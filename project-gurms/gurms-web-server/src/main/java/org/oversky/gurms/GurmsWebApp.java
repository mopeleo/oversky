package org.oversky.gurms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"org.oversky.gurms.system.dao","org.oversky.gurms.system.*.dao"})
@ComponentScan(basePackages = {"org.oversky.gurms","org.oversky.common"})
@EnableTransactionManagement 		// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class GurmsWebApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(GurmsWebApp.class, args);
	}

}

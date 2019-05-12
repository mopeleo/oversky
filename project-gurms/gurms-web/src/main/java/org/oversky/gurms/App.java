package org.oversky.gurms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"org.oversky.gurms.system.dao","org.oversky.gurms.system.*.dao"})
@EnableTransactionManagement 		// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(App.class, args);
	}

}

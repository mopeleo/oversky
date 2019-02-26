package org.oversky.gurms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.oversky.gurms.system.dao")
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(App.class, args);
	}

}
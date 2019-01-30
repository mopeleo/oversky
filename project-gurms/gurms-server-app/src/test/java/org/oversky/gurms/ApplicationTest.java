package org.oversky.gurms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.oversky.gurms.system.dao")
public class ApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTest.class, args);
	}
}

package org.oversky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"org.oversky.dreamland.dao.*","org.oversky.dreamland.ext.dao"})
@ComponentScan(basePackages = {"org.oversky.rocketmq","org.oversky.dreamland","org.oversky.common"})
public class App 
{
    public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);
    }
}

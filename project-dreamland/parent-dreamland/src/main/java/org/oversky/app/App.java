package org.oversky.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App{
    public static void main(String[] args) {
        System.out.println("Hello, springboot 2.0!");
        SpringApplication.run(App.class, args);
    }    
}
package com.zaid.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CoreApplication.class, args);
//		Teacher t = context.getBean(Teacher.class);
//		t.work();

	}

}
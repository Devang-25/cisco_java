package com.cisco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cisco.prj.service.SampleService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		// any object managed by the spring container is a bean
		String[] names = ctx.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("**********");
		
		SampleService ser = ctx.getBean("sampleService",SampleService.class);
		ser.doTask();
	}

}

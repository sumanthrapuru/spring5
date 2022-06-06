package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotaionConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		HappyFortuneService coach1 = context.getBean("happyFortuneService", HappyFortuneService.class);
		HappyFortuneService coach2 = context.getBean("happyFortuneService", HappyFortuneService.class);
		
		
		System.out.println(coach1 == coach2);
		
		context.close();
	}
}

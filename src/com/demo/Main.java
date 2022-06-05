package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HappyFortuneService coach1 = context.getBean("happyFortuneService", HappyFortuneService.class);
		HappyFortuneService coach2 = context.getBean("happyFortuneService", HappyFortuneService.class);
		
		
		System.out.println(coach1 == coach2);
		
		context.close();
	}
}

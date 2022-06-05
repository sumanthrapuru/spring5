package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HappyFortuneService implements FortuneService, DisposableBean{

	@Override
	public String getDailyFortune() {
		return "Happy fortune for you";
	}
	
	@PostConstruct
	private void postConstruct() {
		System.out.println("happyfortuneservice post construct");
	}
	
//	@PreDestroy
//	private void preDestroy() {
//		System.out.println("happyfortuneservice pre destroy");
//	}

	@Override
	public void destroy() throws Exception {
		// can't use @PreDestroy for prototype scope 
		System.out.println("happyfortuneservice pre destroy");
		
	}
}

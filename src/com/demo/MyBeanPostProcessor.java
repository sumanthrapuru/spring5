package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean{

	BeanFactory beanFactory;
	List<Object> beans = new LinkedList<>();
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		
		if(beanFactory.isPrototype(beanName)) {
			synchronized (beans) {
				beans.add(bean);
			}
		}
		
		return bean;
	}
	
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		beanFactory = arg0;
	}

	@Override
	public void destroy() throws Exception {
		synchronized(beans) {
			for(Object bean : beans) {
				if(bean instanceof DisposableBean) {
					DisposableBean disposableBean = (DisposableBean) bean;
					disposableBean.destroy();
				}
			}
		}
		beans.clear();
	}

}

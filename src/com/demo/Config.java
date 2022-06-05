package com.demo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@PostConstruct
	private void initLogger() {
		Logger logger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		Logger loggerParent = logger.getParent();
		loggerParent.setLevel(Level.parse("FINE"));
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.parse("FINE"));
		consoleHandler.setFormatter(new SimpleFormatter());
		
		loggerParent.addHandler(consoleHandler);
	}
}

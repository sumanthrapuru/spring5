package com.demo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:logging.properties")
public class LoggerConfig {
	
	@Value("${root.logger.level}")
	private String rootLogLevel;
	@Value("${printed.logger.level}")
	private String printedLogLevel;
	
	@PostConstruct
	public void initLogger() {
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.parse(printedLogLevel));
		handler.setFormatter(new SimpleFormatter());
		
		Logger loggerParent = Logger.getLogger(AnnotationConfigApplicationContext.class.getName()).getParent();
		loggerParent.setLevel(Level.parse(rootLogLevel));
		loggerParent.addHandler(handler);
	}
	
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
										 @Value("${printed.logger.level}") String printedLoggerLevel) {
 
		MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
 
		return myLoggerConfig;
	}
}

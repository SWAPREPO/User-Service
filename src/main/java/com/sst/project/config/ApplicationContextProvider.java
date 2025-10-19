package com.sst.project.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	/**
	 * Field which holds the application context.
	 * 
	 */
	private static ApplicationContext context;

	/**
	 * <p>This is a getter method which returns the context.</p> 
	 * 
	 * @return instance of application context.
	 */
	public static ApplicationContext getApplicationContext() {
		return context;
	}

	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	/**
	 * <p>This method will call the close method on the application context instance.</p> 
	 * 
	 */
	public static void closeContext() {
		((ConfigurableApplicationContext) getApplicationContext()).close();
	}
}

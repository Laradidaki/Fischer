package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		//LOAD THE SPRING CONFIGURATION FILE
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//RETRIEVE THE BEAN FROM SPRING CONTAINER
		
		Coach theCoach = context.getBean("trackCoach", Coach.class);
	
		System.out.println(theCoach.getDailyWorkout());
		
		
		//CLOSE THE CONTEXT
		context.close();
	}

}

package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		//LOAD THE SPRING CONFIGURATION FILE
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//RETRIEVE THE BEAN FROM SPRING CONTAINER
		
		Coach theCoach = context.getBean("baseballCoach", Coach.class);
		Coach alphaCoach = context.getBean("baseballCoach", Coach.class);
		
		//check if they are the same
		
		boolean result= (theCoach==alphaCoach);
		
		//print out the result
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
		
		//CLOSE THE CONTEXT
		context.close();
	}

}

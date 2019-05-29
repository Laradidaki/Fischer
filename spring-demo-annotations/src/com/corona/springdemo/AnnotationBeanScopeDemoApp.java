package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from the container
		Coach coachOne= context.getBean("tennisCoach", Coach.class);
		Coach coachTwo= context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result= (coachOne==coachTwo);
		System.out.println("Pointing to the same object: "+result);
		
		System.out.println("\nMemory location for coachOne: "+coachOne);
		
		System.out.println("\nMemory location for coachTwo: "+coachTwo);
		
		//close the context
		context.close();

	}

}

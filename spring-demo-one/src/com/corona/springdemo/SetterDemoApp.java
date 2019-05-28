package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		//LOAD THE SPRING CONFIGURATION FILE
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//RETRIVE THE BEAN FROM SPRING CONTAINER
		CricketCoach cricket= context.getBean("cricketCoach", CricketCoach.class);
		
		//CALL METHODS ON THE BEAN
		System.out.println(cricket.getDailyWorkout());
		System.out.println(cricket.getDailyFortune());
		
		//CALL THE NEW METHODS TO GET LITERAL VALUES
		System.out.println(cricket.getEmail());
		System.out.println(cricket.getTeam());
		
		//CLOSE THE CONTEXT
		context.close();
	}

}

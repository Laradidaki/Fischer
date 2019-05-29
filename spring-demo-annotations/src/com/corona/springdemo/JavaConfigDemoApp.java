package com.corona.springdemo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		//READ SPRING CONFIG FILE

		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//RETRIEVE THE BEAN FROM SPRING CONTAINER
		Coach tennisCoach= context.getBean("tennisCoach", Coach.class);
		
		//CALL A METHOD ON THE BEAN
		System.out.println(tennisCoach.getDailyWorkout());
		
		System.out.println(tennisCoach.getDailyFortune());
		
		//CLOSE THE CONTAINER
		context.close();
	}

}

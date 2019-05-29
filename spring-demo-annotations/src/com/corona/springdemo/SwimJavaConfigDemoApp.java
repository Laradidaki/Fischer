package com.corona.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		//READ SPRING CONFIG FILE

		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		//RETRIEVE THE BEAN FROM SPRING CONTAINER
		SwimCoach swimCoach= context.getBean("swimCoach", SwimCoach.class);
		
		//CALL A METHOD ON THE BEAN
		System.out.println(swimCoach.getDailyWorkout());
		
		System.out.println(swimCoach.getDailyFortune());
		
		//CALL OUR NEW SWIM COACH METHODS... HAS THE PROP VALUES INJECTED
		System.out.println("email: "+swimCoach.getEmail()+ "\nteam: "+swimCoach.getTeam());
		
		//CLOSE THE CONTAINER
		context.close();
	}

}

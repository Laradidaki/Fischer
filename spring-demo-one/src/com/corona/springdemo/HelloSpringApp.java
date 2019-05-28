package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		//LOAD THE SPRING CONFIGURATION FILE
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//RETRIVE BEAN FROM SPRING CONTAINER
		Coach baseball= context.getBean("baseballCoach", Coach.class);
		Coach basket= context.getBean("basketCoach", Coach.class);
		Coach track= context.getBean("trackCoach",Coach.class);
		
		//CALL METHODS ON THE BEAN
		System.out.println(baseball.getDailyWorkout());
		System.out.println(basket.getDailyWorkout());
		System.out.println(track.getDailyWorkout());
		
		//LET'S CALL OUR NEW METHOD FOR FORTUNES
		System.out.println(baseball.getDailyFortune());
		System.out.println(basket.getDailyFortune());
		System.out.println(track.getDailyFortune());
		//CLOSE THE CONTEXT
		context.close();
	}

}

package com.corona.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainActor {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Actor theatreActor= context.getBean("theatreActor", Actor.class);
		
		System.out.println(theatreActor.actIn());
		
		context.close();
	}

}

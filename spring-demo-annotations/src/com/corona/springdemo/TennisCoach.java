package com.corona.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("TennisCoach: inside doMyStartUpStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("TennisCoach: inside doMyCleanUpStuff");
	}
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}

	
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}


	@Override
	public String getDailyFortune() {
	
		return fortuneService.getFortune();
	}

}

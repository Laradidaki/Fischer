package com.corona.springdemo;

public class BasketBallCoach implements Coach {
	
	//DEFINE A PRIVATE FIELD FOR THE DEPENDENCY
	private FortuneService fortuneService;
	
	//DEFINE A CONSTRUCTOR FOR DEPENDENCY INJECTION
	public BasketBallCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do practice with third time rule";
	}

	@Override
	public String getDailyFortune() {
		
		//USE MY FORTUNE SERVICE TU GET A FORTUNE
		
		return fortuneService.getFortune();
	}

}

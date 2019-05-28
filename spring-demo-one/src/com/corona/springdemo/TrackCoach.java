package com.corona.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
	
		fortuneService=theFortuneService;
	}
	
	public TrackCoach() {

	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it:"+ fortuneService.getFortune();
	}
	
	//ADD AN INIT METHOD
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: Inside method doMyStartUpStuff");
	}
	
	//ADD A DESTROY METHOD
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: inside the method doMyCleanUpStuff");
	}
	
	

}

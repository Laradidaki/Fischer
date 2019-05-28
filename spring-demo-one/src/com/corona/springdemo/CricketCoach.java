package com.corona.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	
	//ADD NEW FIELDS FOR EMAIL ADDRESS AND TEAM
	private String email;
	private String team;

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setter method - setEmail");
		this.email = email;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	//CREATE NO ARGS CONSTRUCTOR
	public CricketCoach() {
		System.out.println("CricketCoach: inside no args constructor");
	}
	
	//CREATE SETTER METHOD
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

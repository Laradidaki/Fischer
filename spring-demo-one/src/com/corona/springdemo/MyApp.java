package com.corona.springdemo;

public class MyApp {

	public static void main(String[] args) {

		//CREATE THE OBJECT
		Coach coach= new TrackCoach();
		
		//USE THE OBJECT
		System.out.println(coach.getDailyWorkout());
	}

}

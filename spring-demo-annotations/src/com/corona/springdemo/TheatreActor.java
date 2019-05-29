package com.corona.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TheatreActor implements Actor {

	@Override
	public String actIn() {
		return "I act my script in Broadway Theatre";
	}

}

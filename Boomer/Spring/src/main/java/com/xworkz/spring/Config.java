package com.xworkz.spring;

import org.springframework.context.annotation.Bean;

public class Config {
	
	
	@Bean
	public Car getCar() {
		return new Car();
	}

	
	@Bean
	public Bike getBike() {
		return new Bike();
	}
	
}

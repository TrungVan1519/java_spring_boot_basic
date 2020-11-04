package com.example.restcontroller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootDevToolsController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.age}")
	private int coachAge;

	@GetMapping("/")
	public String showHome() {
		return "Time now on server is: " + LocalDateTime.now();
	}
	
	@GetMapping("/forDevTools")
	public String showDailyWorkout() {
		return "Do something useful for the life";
	}

	@GetMapping("/propertiesFile")
	public String showProperties() {
		return "Name: " + coachName + " \nAge: " + (coachAge + 1);
	}
}

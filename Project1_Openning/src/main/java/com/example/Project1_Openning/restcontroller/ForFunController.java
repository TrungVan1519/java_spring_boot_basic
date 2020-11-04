package com.example.Project1_Openning.restcontroller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForFunController {

	@GetMapping("/")
	public String showHome() {
		return "Time now on server is: " + LocalDateTime.now();
	}
}

package com.formypet.jpa.adopt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdoptController {
	
	@GetMapping("/adopt_application")
	public String adopt_application() {
		String forwardPath = "adopt_application";
		return forwardPath;
	}
	
}

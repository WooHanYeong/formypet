package com.formypet.jpa.adopt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdoptController {
	
	
	@GetMapping("/adopt_list")
	public String adopt_list() {
		String forwardPath = "adopt_list";
		return forwardPath;
	}
	
	@GetMapping("/adopt_detail")
	public String adopt_detail() {
		String forwardPath = "adopt_detail";
		return forwardPath;
	}
	
}

package com.formypet.jpa.adopt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdoptController {
	
	
	@GetMapping("/adopt_list_index")
	public String adopt_list_index() {
		String forwardPath = "adopt_list_index";
		return forwardPath;
	}
	
	
	@GetMapping("/adopt_list_dog")
	public String adopt_list_dog() {
		String forwardPath = "adopt_list_dog";
		return forwardPath;
	}
	
	@GetMapping("/adopt_list_cat")
	public String adopt_list_cat() {
		String forwardPath = "adopt_list_cat";
		return forwardPath;
	}
	
	@GetMapping("/adopt_detail")
	public String adopt_detail() {
		String forwardPath = "adopt_detail";
		return forwardPath;
	}
	
	
	@GetMapping("/adopt_application")
	public String adopt_application() {
		String forwardPath = "adopt_application";
		return forwardPath;
	}
	
}

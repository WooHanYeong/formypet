package com.example.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class controller {

	@GetMapping("/index")
	public String index() {
		String forwardPath = "index";
		return forwardPath;
	}
}

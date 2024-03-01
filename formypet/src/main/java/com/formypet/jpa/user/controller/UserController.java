package com.formypet.jpa.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class UserController {
	
	@GetMapping("/user_login_form")
	public String user_login_form() {
		String forwardPath = "user_login_form";
		return forwardPath;
	}
}

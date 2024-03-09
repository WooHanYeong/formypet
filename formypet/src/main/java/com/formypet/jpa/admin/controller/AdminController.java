package com.formypet.jpa.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdminController {
	
	@GetMapping("/admin_index")
	public String dash() throws Exception {
		String forwardPath ="admin_index";
		return forwardPath;
	}
	@GetMapping("/admin_orderinfo")
	public String admin_orderinfo() throws Exception {
		String forwardPath ="admin_orderinfo";
		return forwardPath;
	}
	@GetMapping("/admin_userinfo")
	public String admin_userinfo() throws Exception {
		String forwardPath ="admin_userinfo";
		return forwardPath;
	}
	
}

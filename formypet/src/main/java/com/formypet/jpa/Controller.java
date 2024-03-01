package com.formypet.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	@GetMapping("/index")
	public String index() {
		String forwardPath = "index";
		return forwardPath;
	}
	
	@GetMapping("/confirmation")
	public String confirmation() {
		String forwardPath = "confirmation";
		return forwardPath;
	}
	
	@GetMapping("/blog")
	public String blog() {
		String forwardPath = "blog";
		return forwardPath;
	}
	
	@GetMapping("/board_list")
	public String boardList() {
		String forwardPath = "board_list";
		return forwardPath;
	}
}

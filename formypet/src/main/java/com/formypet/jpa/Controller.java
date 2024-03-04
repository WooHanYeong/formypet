package com.formypet.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.user.dto.SessionUser;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	
	private HttpSession httpSession;

	@GetMapping("/index")
	public String index(org.springframework.ui.Model model) {
		if(httpSession !=null) {
			SessionUser user = (SessionUser) httpSession.getAttribute("user");
			
			if(user!=null) {
				model.addAttribute("userName",user.getName());
			}
		}
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

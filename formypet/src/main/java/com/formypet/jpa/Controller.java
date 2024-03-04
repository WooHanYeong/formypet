package com.formypet.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.user.dto.SessionUser;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	private HttpSession httpSession;

	@GetMapping("/index")
	public String index(HttpServletRequest request ,org.springframework.ui.Model model) {
		
		HttpSession httpSession =request.getSession();
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if (user != null) {
			model.addAttribute("userName", user.getName());
		}
		return "index";
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

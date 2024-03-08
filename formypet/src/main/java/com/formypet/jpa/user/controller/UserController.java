package com.formypet.jpa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user_login_form")
	public String user_login_form() {
		String forwardPath = "user_login_form";
		return forwardPath;
	}

	@GetMapping("/user_create_account_form")
	public String user_create_account_form() {
		String forwardPath = "user_create_account_form";
		return forwardPath;
	}

	@GetMapping("/user_find_account_form")
	public String user_find_account_form() {
		String forwardPath = "user_find_account_form";
		return forwardPath;
	}

	@GetMapping("/user_mypage_form")
	public String user_mypage_form(HttpSession session, Model model) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			UserDto user = userService.findUser(loginUser.getUserId());
			model.addAttribute("loginUser", user);
		}
		return "user_mypage_form";
	}

	// 로그아웃action
	@GetMapping("/user_logout_action")
	public String user_action(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}

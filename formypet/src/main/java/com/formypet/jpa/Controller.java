package com.formypet.jpa;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

	private HttpSession httpSession;
	
	private UserService userService;

	@GetMapping("/index")
	public String index() throws Exception {
		String forwardPath ="index";
	    return forwardPath;
	}
	@GetMapping("/index_dogcontent")
	public String index_dogcontent() throws Exception {
		String forwardPath ="index_dogcontent";
		return forwardPath;
	}
	@GetMapping("/index_catcontent")
	public String index_catcontent() throws Exception {
		String forwardPath ="index_catcontent";
		return forwardPath;
	}

	@GetMapping("/eventpage")
	public String eventpage() {
		String forwardPath = "eventpage";
		return forwardPath;
	}
	
	@GetMapping("/noticepage")
	public String noticepage() {
		String forwardPath = "noticepage";
		return forwardPath;
	}
	
	@GetMapping("/error")
	public String error() {
		String forwardPath = "error";
		return forwardPath;
	}

	@GetMapping("/header")
	public String header(HttpSession session, Model model) throws Exception{
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
	        UserDto user = userService.findUser(loginUser.getUserId());
	        model.addAttribute("loginUser", user);
	    }
		return "header";
	}

	
}

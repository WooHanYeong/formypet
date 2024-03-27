package com.formypet.jpa.adopt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.service.AnimalService;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdoptController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AnimalService animalService;

	@GetMapping("/adopt_application")
	public String adopt_application(@RequestParam(name = "animalId") Long id, HttpSession session, Model model)
			throws Exception {
		//세션처리
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
			UserDto user = userService.findUser(loginUser.getUserId());
			model.addAttribute("loginUser", user);
		}
		
		Optional<Animal> animalOptional =
				animalService.findById(id);
		Animal animalObject = animalOptional.get();
		model.addAttribute("animalObject",animalObject);
		
		
		return "adopt_application";
	}

}

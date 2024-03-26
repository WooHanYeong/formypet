package com.formypet.jpa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.animal.entity.Animal;
import com.formypet.jpa.animal.service.AnimalService;
import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.service.ProductServiceImpl;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private AnimalService animalService;
	
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
	
	//회원관리
	@GetMapping("/admin_userinfo")
	public String admin_userinfo(Model model) throws Exception {
		List<User> userList = userServiceImpl.findByAllUser();	
		model.addAttribute("userList",userList);
		return "admin_userinfo";
	}
	//상품관리
	@GetMapping("/admin_productinfo")
	public String admin_productinfo(Model model) throws Exception {
		List<Product> productList =productServiceImpl.findAllProductList();
		model.addAttribute("productList",productList);
		return "admin_productinfo";
	}
	@GetMapping("/admin_create_product")
	public String admin_create_product() throws Exception {
		String forwardPath ="admin_create_product";
		return forwardPath;
	}
	
	//동물관리
	@GetMapping("/admin_animalinfo")
	public String admin_animalinfo(Model model) throws Exception {
		List<Animal> animalList = animalService.findAllAnimalList();
		System.out.println("애니멀리스트"+animalList);
		model.addAttribute("animalList",animalList);
		return "admin_animalinfo";
	}
	@GetMapping("/admin_create_animal")
	public String admin_create_animal() throws Exception {
		String forwardPath ="admin_create_animal";
		return forwardPath;
	}
	
	
}
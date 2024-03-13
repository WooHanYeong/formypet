package com.formypet.jpa.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.service.ProductServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	//강아지 상품 리스트
	@GetMapping("/product_list_dog")
	public String product_list_dog(Model model) {
		List<Product> dogList = productServiceImpl.findByProductAnimalType_OrderByCreatedTimeDesc("강아지");
		model.addAttribute("dogList", dogList);
		System.out.println("강아지리스트(최신)" + dogList);
		return "product_list_dog";
	}

	@GetMapping("/product_list_cat")
	public String product_list_cat(Model model) {
		List<Product> catList = productServiceImpl.findByProductAnimalType_OrderByCreatedTimeDesc("고양이");
		model.addAttribute("catList", catList);
		System.out.println("고양이리스트(최신)" + catList);
		return "product_list_cat";
	}

	@GetMapping("/product_detail_dog")
	public String product_detail_dog() {
		String forwardPath = "product_detail_dog";
		return forwardPath;
	}

	@GetMapping("/product_detail_cat")
	public String product_detail_cat() {
		String forwardPath = "product_detail_cat";
		return forwardPath;
	}



}

package com.formypet.jpa.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class ProductController {

	@GetMapping("/product_list_dog")
	public String product_list_dog() {
		String forwardPath = "product_list_dog";
		return forwardPath;
	}
	@GetMapping("/product_list_cat")
	public String product_list_cat() {
		String forwardPath = "product_list_cat";
		return forwardPath;
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

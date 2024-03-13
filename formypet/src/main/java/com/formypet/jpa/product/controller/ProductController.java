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
		List<Product> dogListCategory1 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "건사료");
		List<Product> dogListCategory2 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "배변패드");
		List<Product> dogListCategory3 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "방석/쿠션");
		List<Product> dogListCategory4 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "이동가방");
		List<Product> dogListCategory5 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "샴푸/비누");
		List<Product> dogListCategory6 = productServiceImpl.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "기타");
		model.addAttribute("dogListCategory1", dogListCategory1);
		model.addAttribute("dogListCategory2", dogListCategory2);
		model.addAttribute("dogListCategory3", dogListCategory3);
		model.addAttribute("dogListCategory4", dogListCategory4);
		model.addAttribute("dogListCategory5", dogListCategory5);
		model.addAttribute("dogListCategory6", dogListCategory6);
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

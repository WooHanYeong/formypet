package com.formypet.jpa.product.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.service.ProductServiceImpl;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private UserService userService;

	// 강아지 상품 리스트
	@GetMapping("/product_list_dog")
	public String product_list_dog(Model model) {

		// 강아지타입productlist
		List<Product> dogList = productServiceImpl.findByProductAnimalType_OrderByCreatedTimeDesc("강아지");
		model.addAttribute("dogList", dogList);

		// 강아지 top4 상품리스트
		List<Product> sortedDogList = new ArrayList<>(dogList);
		sortedDogList.sort(Comparator.comparing(Product::getProduct_ReadCount).reversed());
		List<Product> top4DogList = sortedDogList.subList(0, Math.min(sortedDogList.size(), 4));
		System.out.println("top4DogList = >>>>>" + top4DogList);
		model.addAttribute("top4DogList", top4DogList);

		// 카테고리리스트
		List<Product> dogListCategory1 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "건사료");
		List<Product> dogListCategory2 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "배변패드");
		List<Product> dogListCategory3 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "방석/쿠션");
		List<Product> dogListCategory4 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "이동가방");
		List<Product> dogListCategory5 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "샴푸/비누");
		List<Product> dogListCategory6 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("강아지", "기타");
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

		// 고양이타입productlist
		List<Product> catList = productServiceImpl.findByProductAnimalType_OrderByCreatedTimeDesc("고양이");
		model.addAttribute("catList", catList);
		System.out.println("고양이리스트(최신)" + catList);

		// 고양이 top4 상품리스트
		List<Product> sortedCatList = new ArrayList<>(catList);
		sortedCatList.sort(Comparator.comparing(Product::getProduct_ReadCount).reversed());
		List<Product> top4CatList = sortedCatList.subList(0, Math.min(sortedCatList.size(), 4));
		System.out.println("top4CatList = >>>>>" + top4CatList);
		model.addAttribute("top4CatList", top4CatList);

		// 카테고리리스트
		List<Product> catListCategory1 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "건사료");
		List<Product> catListCategory2 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "배변패드");
		List<Product> catListCategory3 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "방석/쿠션");
		List<Product> catListCategory4 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "이동가방");
		List<Product> catListCategory5 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "샴푸/비누");
		List<Product> catListCategory6 = productServiceImpl
				.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc("고양이", "기타");
		model.addAttribute("catListCategory1", catListCategory1);
		model.addAttribute("catListCategory2", catListCategory2);
		model.addAttribute("catListCategory3", catListCategory3);
		model.addAttribute("catListCategory4", catListCategory4);
		model.addAttribute("catListCategory5", catListCategory5);
		model.addAttribute("catListCategory6", catListCategory6);

		return "product_list_cat";
	}

	@GetMapping("/product_detail_dog")
	public String product_detail_dog(HttpSession session, @RequestParam(name="productId")Long id, Model model) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			UserDto user = userService.findUser(loginUser.getUserId());
			model.addAttribute("loginUser", user);
		}
		//삼풍가져오기
		Optional<Product> productOptional =productServiceImpl.findById(id);
		if(productOptional.isPresent()) {
			Product product =productOptional.get();
			model.addAttribute("product", product);
		}else {
			// 게시물이 존재하지 않을 경우 에러 처리
			model.addAttribute("errorMSG", "게시물을 찾을 수 없습니다.");
		}
		
		return "product_detail_dog";
	}

	@GetMapping("/product_detail_cat")
	public String product_detail_cat(@RequestParam(name="productId")Long id, Model model) {
		
		//삼풍가져오기
				Optional<Product> productOptional =productServiceImpl.findById(id);
				if(productOptional.isPresent()) {
					Product product =productOptional.get();
					model.addAttribute("product", product);
				}else {
					// 게시물이 존재하지 않을 경우 에러 처리
					model.addAttribute("errorMSG", "게시물을 찾을 수 없습니다.");
				}
		
		return "product_detail_cat";
	}

}

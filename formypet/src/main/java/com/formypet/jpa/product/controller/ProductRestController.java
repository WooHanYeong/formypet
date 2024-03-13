
package com.formypet.jpa.product.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	// 상품등록 (완)
	@PostMapping("/productInsertForm")
	public ResponseEntity<String> insertProduct(@RequestParam("imageFile1") MultipartFile file1,
			@RequestParam("productName") String productName, @RequestParam("productContent") String productContent,
			@RequestParam("productAnimalType") String productAnimalType,
			@RequestParam("productCategory") String productCategory,
			@RequestParam("productPrice") String productPrice) {
		try {
			// 파일 저장
			String uploadPath1 = System.getProperty("user.dir") + "/src/main/resources/static/productimg/";
			String originalFileName1 = file1.getOriginalFilename();
			UUID uuid1 = UUID.randomUUID();
			String savedFileName1 = uuid1.toString() + "_" + originalFileName1;
			File newFile1 = new File(uploadPath1 + savedFileName1);
			file1.transferTo(newFile1);

			// 상품 정보 저장
			Product product = new Product(null, productName, productContent, productAnimalType, productCategory,
					productPrice, savedFileName1, 0, null, null);
			productService.insert(product);

			// 성공 응답 반환
			return ResponseEntity.ok("Product uploaded successfully.");
		} catch (Exception e) {
			// 실패 시 오류 응답 반환
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload product.");
		}
	}

}

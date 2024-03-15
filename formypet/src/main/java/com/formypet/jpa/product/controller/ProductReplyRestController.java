package com.formypet.jpa.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.entity.ProductReply;
import com.formypet.jpa.product.service.ProductReplyService;
import com.formypet.jpa.product.service.ProductService;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/productcomment")
public class ProductReplyRestController {

	@Autowired
	private ProductReplyService productReplyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@Operation(summary = "댓글 등록[테스트성공]")
	@PostMapping("/productCommentInsertForm/{productId}")
	public ResponseEntity<String> insertComment(@PathVariable("productId") Long productId,
			@RequestParam("productReplyTitle") String productReplyTitle,
			@RequestParam("productReplyContent") String productReplyContent,
			@RequestParam("userId") Long userId) {
		
		User findUser = userService.findUserById(userId);
		
		Product findProduct = productService.findById(productId).orElse(null);
		
		try {
			ProductReply productReply = new ProductReply(null, productReplyTitle, productReplyContent, null, findProduct, findUser);
			productReplyService.createReply(productReply);
			return ResponseEntity.ok("성공");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload product.");
		}
	}
	
	@Operation(summary = "댓글삭제[테스트성공]")
	@DeleteMapping("/productReplyDelete/{productReplyId}")
	public void ProductReplyDelete(@PathVariable(name="productReplyId") Long id) {
		productReplyService.deleteReply(id);
	}

}

package com.formypet.jpa.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.product.entity.Product;
import com.formypet.jpa.product.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	//상품등록
	@Override
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	//강아지,고양이 카테고리 분류(최신순서)
	@Override
	public List<Product> findByProductAnimalType_OrderByCreatedTimeDesc(String productcategory) {
		return productRepository.findByProductAnimalType_OrderByCreatedTimeDesc(productcategory);
	}
	
	//강아지물품 카테고리 분류 (최신순서)
	@Override
	public List<Product> findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc(String animalType, String productcategory) {
		return productRepository.findByProductAnimalTypeAndProductCategoryOrderByCreatedTimeDesc(animalType, productcategory);
	}
	
	//상품조회수 증가.(컨트롤러에 추가)
	@Override
	public Product increaseReadCount(Product product) {
		Product findproduct = productRepository.findById(product.getId()).orElse(null);
		if(findproduct !=null) {
			findproduct.setProduct_ReadCount(findproduct.getProduct_ReadCount()+1);
			productRepository.save(findproduct);
		}
		return findproduct;
	}
	
	
	
}

package com.formypet.jpa.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

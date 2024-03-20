package com.formypet.jpa.board.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.formypet.jpa.FormypetApplicationTest;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

import jakarta.transaction.Transactional;

public class BoardSubCategoryServiceImplTest extends FormypetApplicationTest {
	@Autowired
	BoardService boardService;
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void subCate() throws Exception {
		Long subCategoryId = 1L;
		List<String> subcategory= boardService.getSubCategoryName(subCategoryId);
		System.out.println("asdasd"+subcategory);
		
	}
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void subCate2() throws Exception {
		Long categoryId = 1L;
		List<String> subcategory= boardService.getSubCategoryNameByCategoryBySubCategoryId(categoryId);
		System.out.println("asdasd"+subcategory);
		
	}
	


	
	

}

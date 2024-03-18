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
	BoardSubCategoryServiceImpl boardSubCategoryServiceImpl;
	@Autowired
	BoardService boardService;
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void subCate() throws Exception {
		Long categoryId = 1L;
		List<String> test1 = boardSubCategoryServiceImpl.getSubCategoryNameByMainCategoryId(categoryId);
		for (String subCategoryName : test1) {
			System.out.println(subCategoryName);
		}
	}
	/*
	@Test
	@Transactional
	// @Disabled
	@Rollback(false)
	void subCategory() throws Exception {
		Long subCategoryId = 10L;
		List<Board> test1 = boardService.getBoardSubCategoryIds(subCategoryId);
		System.out.println("asdsadsad"+test1);
	}
	*/

	
	

}

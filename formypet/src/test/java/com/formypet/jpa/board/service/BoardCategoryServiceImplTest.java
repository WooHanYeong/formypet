package com.formypet.jpa.board.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.formypet.jpa.FormypetApplicationTest;
import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.dto.BoardDto;

import jakarta.transaction.Transactional;

public class BoardCategoryServiceImplTest extends FormypetApplicationTest {
	@Autowired
	BoardCategoryService boardCategoryService;
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void createCategory() throws Exception{
		BoardCategoryDto dto1 = new BoardCategoryDto();
		dto1.setCategoryName("분양");
		boardCategoryService.createCategory(dto1);
		BoardCategoryDto dto2 = new BoardCategoryDto();
		dto2.setCategoryName("이벤트");
		boardCategoryService.createCategory(dto2);
		BoardCategoryDto dto3 = new BoardCategoryDto();
		dto3.setCategoryName("공지사항");
		boardCategoryService.createCategory(dto3);
		
	}
	
	
}

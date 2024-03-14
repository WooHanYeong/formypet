package com.formypet.jpa.board.service;

import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.entity.BoardCategory;

public interface BoardCategoryService {
	
	public BoardCategory createCategory(BoardCategoryDto boardCategoryDto) throws Exception;
	
	public void deleteCategory(Long boardCategoryId) throws Exception;
	
}

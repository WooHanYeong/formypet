package com.formypet.jpa.board.service;

import java.util.List;

import com.formypet.jpa.board.entity.BoardSubCategory;

public interface BoardSubCategoryService {
	public List<BoardSubCategory> getSubCategoryByMainCategoryId(Long categoryId) throws Exception;
	public List<BoardSubCategory> getSubCategory(Long subCategoryId) throws Exception;
	public List<BoardSubCategory> getSubCategoryAll() throws Exception;
	
}

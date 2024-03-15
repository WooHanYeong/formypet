package com.formypet.jpa.board.service;

import java.util.List;

public interface BoardSubCategoryService {
	
	public List<String> getSubCategoryNameByMainCategoryId(Long categoryId) throws Exception;
	
}

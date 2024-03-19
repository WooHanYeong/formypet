package com.formypet.jpa.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;
import com.formypet.jpa.board.repository.BoardCategoryRepository;
import com.formypet.jpa.board.repository.BoardSubCategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardSubCategoryServiceImpl implements BoardSubCategoryService {
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	@Autowired
	BoardSubCategoryRepository boardSubCategoryRepository;

	/*
	 * @Override public List<BoardSubCategory> getSubCategoryByMainCategoryId(Long
	 * categoryId) throws Exception { List<BoardSubCategory> subCategoryList = new
	 * ArrayList<>(); BoardCategory category =
	 * boardCategoryRepository.findById(categoryId).orElse(null); if (category !=
	 * null) { List<BoardSubCategory> subCategories = category.getSubCategories();
	 * for (BoardSubCategory subCategory : subCategories) { if
	 * (category.getCategoryId().equals(subCategory.getBoardCategory().getCategoryId
	 * ())) { subCategoryList.add(subCategory); } } } return subCategoryList; }
	 * 
	 * @Override public List<BoardSubCategory> getSubCategory(Long subCategoryId)
	 * throws Exception { return
	 * boardSubCategoryRepository.findBySubCategoryId(subCategoryId); }
	 * 
	 * @Override public List<BoardSubCategory> getSubCategoryAll() throws Exception
	 * { return boardSubCategoryRepository.findAll(); }
	 */

}

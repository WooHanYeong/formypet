package com.formypet.jpa.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.repository.BoardCategoryRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BoardCategoryServiceImpl implements BoardCategoryService{
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	
	@Override
	public BoardCategory createCategory(BoardCategoryDto boardCategoryDto) throws Exception {
		BoardCategory boardCategory = BoardCategory.builder()
														.categoryName(boardCategoryDto.getCategoryName())
														.build();
		return boardCategoryRepository.save(boardCategory);
	}

	@Override
	public void deleteCategory(Long boardCategoryId) throws Exception {
		boardCategoryRepository.deleteById(boardCategoryId);
	}

}

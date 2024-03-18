package com.formypet.jpa.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

public interface BoardSubCategoryRepository extends JpaRepository<BoardSubCategory, Long>{
	//List<BoardSubCategory> findBySubCategoryId(Long subCategoryId);
	
}

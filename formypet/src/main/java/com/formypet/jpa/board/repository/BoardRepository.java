package com.formypet.jpa.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByBoardCategoryCategoryId(Long categoryId);

	List<Board> findByBoardCategoryCategoryIdAndBoardSubCategorySubCategoryId(Long categoryId, Long subCategoryId);

	Board findByBoardId(Long boardId);

	List<Board> findByBoardTitleContaining(String keyword);

	List<Board> findAllByOrderByCreatedTimeDesc();

	List<Board> findByBoardCategoryCategoryIdAndBoardSubCategorySubCategoryIdOrderByCreatedTimeDesc(Long categoryId,
			Long subCategoryId);
}

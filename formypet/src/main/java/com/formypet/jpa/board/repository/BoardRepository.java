package com.formypet.jpa.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByBoardCategoryCategoryId(Long categoryId);
	List<Board> findByBoardCategoryCategoryName(String categoryName);
}

package com.formypet.jpa.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long>{
}

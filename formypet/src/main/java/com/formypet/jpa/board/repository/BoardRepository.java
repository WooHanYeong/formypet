package com.formypet.jpa.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}

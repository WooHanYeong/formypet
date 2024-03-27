package com.formypet.jpa.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardReply;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>{

}

package com.formypet.jpa.board.service;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.formypet.jpa.FormypetApplicationTest;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

public class BoardServiceImplTest extends FormypetApplicationTest{
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void createBoard() throws Exception{
		Board board1 = new Board(null, "게시판1", "게시판1의 내용", "게시판1이미지", 0, null, null);
		boardService.createBoard(board1);
		Board board2 = new Board(null, "게시판2", "게시판2의 내용", "게시판2이미지", 0, null, null);
		boardService.createBoard(board2);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void deleteBoard() throws Exception {
		boardService.deleteBoard(1L);
	}
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void updateBoard() throws Exception {
		Long boardId = 2L;
		BoardDto updateBoard = new BoardDto(boardId, "제목만수정", null, null, 0, null, null);
		boardService.updateBoard(boardId, updateBoard);
	
	}
	
	
}


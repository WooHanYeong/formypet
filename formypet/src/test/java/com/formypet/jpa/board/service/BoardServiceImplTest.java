package com.formypet.jpa.board.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.formypet.jpa.FormypetApplicationTest;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

public class BoardServiceImplTest extends FormypetApplicationTest{
	@Autowired
	private BoardService boardService;

	
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void createBoard() throws Exception {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardCategoryId(1L);
		boardDto.setBoardContent("test1");
		boardDto.setBoardId(null);
		boardDto.setBoardImage(null);
		boardDto.setBoardReadCount(0);
		boardDto.setBoardTitle("test1");
		Board board = boardService.createBoard(boardDto);
		System.out.println("boardCreateTest"+board);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void deleteBoard() throws Exception {
		boardService.deleteBoard(1L);
	}

	
	

}

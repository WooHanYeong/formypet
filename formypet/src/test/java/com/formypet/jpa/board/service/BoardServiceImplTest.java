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
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

public class BoardServiceImplTest extends FormypetApplicationTest{
	@Autowired
	private BoardService boardService;
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void createBoard() throws Exception{
		BoardDto boardDto1 = new BoardDto();
		boardDto1.setBoardTitle("제목1");
		boardDto1.setBoardContent("내용1");
		boardDto1.setBoardImage("이미지1");
		boardDto1.setBoardReadCount(1);
		boardDto1.setBoardCategoryId(1L);
		boardService.createBoard(boardDto1);
		
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void deleteBoard() throws Exception {
		boardService.deleteBoard(1L);
	}
	/*
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void updateBoard() throws Exception {
		Long boardId = 2L;
		BoardDto updateBoard = new BoardDto(boardId, "제목만수정", null, null, 0);
		boardService.updateBoard(boardId, updateBoard);
	
	}
	*/
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectBoard() throws Exception {
		Long boardId = 1L;
		Optional<Board> findBoard = boardService.getBoardById(boardId);
		System.out.println("한개정보"+findBoard);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectBoardAll() throws Exception {
		List<Board> boardList = boardService.getBoardByAll();
		System.out.println("보드리스트:"+boardList);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectBoardByCategoryId() throws Exception {
		Long categoryId = 1L;
		List<Board> test1 =  boardService.getBoardByCategoryId(categoryId);
		System.out.println("asdsadsadas"+test1);
	}
	
	@Test
	@Transactional
	// @Disabled
	@Rollback(false)
	void boardListbySub() throws Exception {
		Long categoryId = 1L;
		Long subCategoryId = 1L;
		List<Board> boardList = boardService.getBoardByCategoryIdBySubCategory(categoryId, subCategoryId);
		System.out.println("adsadsadsadsad"+boardList);
	}
	
}

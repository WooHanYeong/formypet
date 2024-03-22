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
import com.formypet.jpa.board.entity.BoardSubCategory;
import com.formypet.jpa.board.repository.BoardRepository;

import jakarta.transaction.Transactional;

public class BoardServiceImplTest extends FormypetApplicationTest{
	@Autowired
    BoardService boardService;
	@Autowired
	BoardRepository boardRepository;

	
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void createBoard() throws Exception {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardCategoryId(1L);
		boardDto.setBoardContent("test2");
		boardDto.setBoardId(null);
		boardDto.setBoardImage(null);
		boardDto.setBoardReadCount(0);
		boardDto.setBoardTitle("test2");
		Board board = boardService.createBoardByMainCategory(boardDto);
		System.out.println("boardCreateTest"+board);
	}
    @Test
	@Transactional
	@Disabled
	@Rollback(false)
    public void createBoardSubCate() throws Exception {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardCategoryId(1L);
        boardDto.setBoardSubCategoryId(1L);
        boardDto.setBoardTitle("제목");
        boardDto.setBoardContent("내용");
        Board createdBoard = boardService.createBoardByMainCategoryBySubCategory(boardDto);
        System.out.println("categoryAndSubCategory"+createdBoard);
    
    }
    
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void deleteBoard() throws Exception {
		boardService.deleteBoard(2L);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void updateBoard() throws Exception {
		Long boardId = 3L;
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardTitle("updateTitle");
		boardDto.setBoardContent("updateContent");
		boardService.updateBoard(boardId, boardDto);
	}

	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectAll() throws Exception {
		List<Board> boards = boardService.getBoardByAll();
		System.out.println("게시글 전체 조회"+boards);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectByCategoryId() throws Exception {
		Long categoryId = 1L;
		List<Board> boards = boardService.getBoardByCategoryId(categoryId);
		System.out.println("게시글 카테고리별 조회"+boards);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void selectByCategoryIdAndSubCategoryId() throws Exception {
		Long categoryId = 1L;
		Long subCategoryId = 2L;
		List<Board> boards = boardService.getBoardByCategoryIdAndSubCategoryId(categoryId, subCategoryId);
		System.out.println("게시글 카테고리의 서브카테고리별 조회"+boards);
	}
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void subCategory() throws Exception {
		Long categoryId = 1L;
		List<String> string = boardService.getSubCategoryByCategoryId(categoryId);
		System.out.println("서브카테고리 조회"+string);
	}
	
	@Test
	@Transactional
	//@Disabled
	@Rollback(false)
	void subCategory1() throws Exception {
		Long subCategoryId = 1L;
		List<String> string = boardService.getSubCategoryName(subCategoryId);
		System.out.println("서브카테고리 조회"+string);
	}
	
	

}

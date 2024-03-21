package com.formypet.jpa.board.service;


import java.util.List;
import java.util.Optional;

import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

public interface BoardService {
	
	//게시판 카테고리별 글작성
	public Board createBoardByMainCategory(BoardDto boardDto) throws Exception;
	
	//게시판 카테고리의 서브카테고리별 글작성
	public Board createBoardByMainCategoryBySubCategory(BoardDto boardDto) throws Exception;

	//게시판 글삭제
	public void deleteBoard(Long boardId) throws Exception;
	
	//게시판 글수정
	public Board updateBoard(Long boardId,BoardDto boardDto) throws Exception;
	
	//게시글 1개 조회
	public Board selectBoard(Long boardId) throws Exception;
	
	//게시판 글 모두 조회
	public List<Board> getBoardByAll() throws Exception;
	
	//게시판 글 상위카테고리별 리스트 조회
	public List<Board> getBoardByCategoryId(Long categoryId) throws Exception;
	
	//게시판 글 상위카테고리의 하위카테고리별 리스트 조회
	public List<Board> getBoardByCategoryIdAndSubCategoryId(Long categoryId ,Long subCategoryId) throws Exception;
	
	//게시판 상위 카테고리 조회
	public BoardCategory getBoardCategoryByCategoryId(Long categoryId) throws Exception;
	
	//게시판 상위카테고리별 서브카테고리 조회
	public List<BoardSubCategory> getSubCategoryByCategoryBySubCategoryId(Long categoryId) throws Exception; 
	
	//게시판 서브카테고리 이름 조회
	public List<String> getSubCategoryName(Long subCategoryId) throws Exception;
	
	//board_list{categoryId} 컨트롤러 subCategoryId 찾기
	public List<String> getSubCategoryByCategoryId(Long categoryId) throws Exception;  
	
	//조회수 증가
	public void increaseReadCount(Long boardId) throws Exception;  
	
	//추천수 증가
	public void updateRecommendCount(Long boardId, int recommendCount) throws Exception;
}

package com.formypet.jpa.board.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;

public interface BoardService {
	
	//게시판 카테고리별 글작성
	public Board createBoardByMainCategory(BoardDto boardDto) throws Exception;
	
	//게시판 카테고리의 서브카테고리별 글작성
	public Board createBoardByMainCategoryBySubCategory(BoardDto boardDto, String userId) throws Exception;

	//게시판 글삭제
	public void deleteBoard(Long boardId) throws Exception;
	
	//게시판 글수정
	public Board updateBoard(Long boardId,BoardDto boardDto) throws Exception;
	
	//게시글 1개 조회
	public Optional<Board> selectBoard(Long boardId);
	
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
	
	//서브카테고리 다시
	public String subCategoryNameBySubCategoryId(Long subCategoryId) throws Exception;
	
	//키워드별 리스트 검색
	public List<Board> searchBoardByKeyword(String keyword) throws Exception;
	
	//작성시간별 내림차순 정렬
	public List<Board> getAllBoardsSortedByCreatedTimeDesc() throws Exception;
	
	//하위카테고리 시간별 정렬
	public List<Board> getBoardsByCategoryIdAndSubCategoryIdSortedByCreatedTimeDesc(Long categoryId ,Long subCategoryId) throws Exception;
	
    // 모든 게시글을 생성된 시간에 따라 내림차순으로 정렬하여 페이지로 가져오는 메소드
    Page<Board> getAllBoardsSortedByCreatedTimeDescPaged(Pageable pageable) throws Exception;

    // 카테고리별 게시글을 페이지로 가져오는 메소드
    Page<Board> getBoardByCategoryIdPaged(Long categoryId, Pageable pageable) throws Exception;
    
    // categoryId와 subCategoryId에 따라 생성된 시간 내림차순으로 페이지네이션된 게시물 가져오기
    public Page<Board> getBoardsByCategoryIdAndSubCategoryIdSortedByCreatedTimeDescPaged(Long categoryId, Long subCategoryId, Pageable pageable) throws Exception;
    
    // categoryId와 subCategoryId에 따라 페이지네이션된 게시물 가져오기
    public Page<Board> getBoardByCategoryIdAndSubCategoryIdPaged(Long categoryId, Long subCategoryId, Pageable pageable) throws Exception;
	
}
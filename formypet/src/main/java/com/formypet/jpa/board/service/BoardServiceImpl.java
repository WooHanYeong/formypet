package com.formypet.jpa.board.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.stereotype.Service;

import com.formypet.jpa.board.dto.BoardCategoryDto;
import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.dto.BoardSubCategoryDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;
import com.formypet.jpa.board.repository.BoardCategoryRepository;
import com.formypet.jpa.board.repository.BoardRepository;
import com.formypet.jpa.board.repository.BoardSubCategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	@Autowired
	BoardSubCategoryRepository boardSubCategoryRepository;

	//메인 카테고리별 create 서비스
	@Override
	public Board createBoardByMainCategory(Long categoryId, BoardDto boardDto) throws Exception {
	    BoardCategory boardCategory = boardCategoryRepository.findById(categoryId)
	            .orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));
	    Board board = Board.builder()
	            .boardTitle(boardDto.getBoardTitle())
	            .boardContent(boardDto.getBoardContent())
	            .boardImage(boardDto.getBoardImage())
	            .boardCategory(boardCategory)
	            .build();
	    
	    return boardRepository.save(board);
	}
	
	//메인 카테고리의 서브카테고리별 create 서비스
	@Override
	public Board createBoardByMainCategoryBySubCategory(BoardDto boardDto,Long subCategoryId) throws Exception {
		BoardCategory boardCategory = boardCategoryRepository.findById(boardDto.getBoardCategoryId())
				.orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));
		Optional<BoardSubCategory> boardSubCategoryOptional = boardSubCategoryRepository.findById(subCategoryId);
		BoardSubCategory boardSubCategory = boardSubCategoryOptional.orElseThrow(() -> new Exception("해당하는 서브 카테고리가 존재하지 않습니다."));
		Board board = Board.builder()
				.boardTitle(boardDto.getBoardTitle())
				.boardContent(boardDto.getBoardContent())
				.boardImage(boardDto.getBoardImage())
				.boardCategory(BoardCategory.builder().categoryId(boardDto.getBoardCategoryId()).build())
				.boardCategory(boardCategory)
				.build();
		return boardRepository.save(board);
	}
	
	//boardId를 통한 게시글 삭제
	@Override
	public void deleteBoard(Long boardId) throws Exception {
		boardRepository.deleteById(boardId);
	}

	//boardId를 통한 게시글 업데이트
	@Override
	public Board updateBoard(Long boardId, BoardDto boardDto) throws Exception {
		Optional<Board> optionalBoard = boardRepository.findById(boardId);
		if (optionalBoard.isPresent()) {
			Board findBoard = optionalBoard.get();
			findBoard.setBoardTitle(boardDto.getBoardTitle());
			findBoard.setBoardContent(boardDto.getBoardContent());
			findBoard.setBoardImage(boardDto.getBoardImage());
			return boardRepository.save(findBoard);
		} else {
			throw new Exception("id를 찾을수 없습니다.: " + boardId);
		}
	}
	
	//게시글 모두 조회
	@Override
	public List<Board> getBoardByAll() throws Exception {
		return boardRepository.findAll();
	}

	//게시글 상위 카테고리별 조회
	@Override
	public List<Board> getBoardByCategoryId(Long categoryId) throws Exception {
		return boardRepository.findByBoardCategoryCategoryId(categoryId);
	}
	

	@Override
	public List<Board> getBoardByCategoryIdAndSubCategoryId(Long categoryId ,Long subCategoryId) throws Exception {
	    BoardCategory boardCategory = boardCategoryRepository.findById(categoryId)
	            .orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));

	    // 카테고리에서 서브 카테고리 목록 조회
	    List<BoardSubCategory> subCategories = boardCategory.getSubCategories();

	    // 서브 카테고리 목록에서 원하는 서브 카테고리 필터링
	    Optional<BoardSubCategory> matchingSubCategory = subCategories.stream()
	            .filter(subCategory -> subCategory.getSubCategoryId().equals(subCategoryId))
	            .findFirst();

	    if (matchingSubCategory.isPresent()) {
	        // 해당 서브 카테고리에 속하는 보드 목록 가져오기
	        return matchingSubCategory.get().getBoardCategory().getBoards();
	    } else {
	        throw new Exception("해당하는 서브 카테고리가 존재하지 않습니다.");
	    }
	}
	
}
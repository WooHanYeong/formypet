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

import com.formypet.jpa.board.dto.BoardDto;
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

	public Board createBoard(BoardDto boardDto) throws Exception {
		System.out.println("dto 확인" + boardDto);
		Board board = Board.builder().boardTitle(boardDto.getBoardTitle()).boardContent(boardDto.getBoardContent())
				.boardImage(boardDto.getBoardImage()).boardReadCount(boardDto.getBoardReadCount())
				.boardSubCategory(BoardSubCategory.builder().subCategoryId(boardDto.getBoardSubCategoryId()).build()).build();
		System.out.println("board확인" + board);
		return boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long boardId) throws Exception {
		boardRepository.deleteById(boardId);
	}

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

	@Override
	public Optional<Board> getBoardById(Long boardId) throws Exception {
		return boardRepository.findById(boardId);
	}

	@Override
	public List<Board> getBoardByAll() throws Exception {
		return boardRepository.findAll();
	}

	@Override
	public List<Board> getBoardBySubCategoryId(Long subCategoryId) throws Exception {
		return boardRepository.findByBoardSubCategorySubCategoryId(subCategoryId);
	}

	@Override
	public List<Board> getBoardBySubCategoryName(String subCategoryName) throws Exception {
		return boardRepository.findByBoardSubCategorySubCategoryName(subCategoryName);
	}
/*
	@Override
	public List<Board> getBoardSubCategoryIds(Long subCategoryId) {
		List<BoardSubCategory> subCategories = boardSubCategoryRepository.findBySubCategoryId(subCategoryId);
		List<Long> categoryIds = new ArrayList<>();
		for (BoardSubCategory subCategory : subCategories) {
			categoryIds.add(subCategory.getBoardCategory().getCategoryId());
		}
		return boardRepository.findAllById(categoryIds);
	}
*/

	@Override
	public List<BoardCategory> getBoardCategoryById(Long categoryId) throws Exception {
		return boardCategoryRepository.findByCategoryId(categoryId);
	}	
}

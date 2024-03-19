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
	    BoardCategory boardCategory = boardCategoryRepository.findById(boardDto.getBoardCategoryId())
	            .orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));
	    Board board = Board.builder()
	            .boardTitle(boardDto.getBoardTitle())
	            .boardContent(boardDto.getBoardContent())
	            .boardImage(boardDto.getBoardImage())
	            .boardReadCount(boardDto.getBoardReadCount())
	            .boardCategory(boardCategory)
	            .build();
	    
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
	public List<Board> getBoardByAll() throws Exception {
		return boardRepository.findAll();
	}
	
	
}
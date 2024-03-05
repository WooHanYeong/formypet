package com.formypet.jpa.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.service.BoardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/create")
	public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto){
		try {
			Board board = Board.toEntity(boardDto);
			Board createBoard = boardService.createBoard(board);
			BoardDto cBoardDto = BoardDto.toDto(createBoard);
			return new ResponseEntity<>(cBoardDto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
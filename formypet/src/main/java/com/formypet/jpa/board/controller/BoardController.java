package com.formypet.jpa.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.service.BoardService;
@Controller
@RequestMapping("/")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board_list")
	public String boardList(Model model) throws Exception {
		List<Board> boardList = boardService.getBoardByAll();
		model.addAttribute("boardList",boardList);
		String forwardPath = "board_list";
		return forwardPath;
	}
	
	@GetMapping("/board_write")
	public String boardWrite() {
		String forwardPath = "board_write";
		return forwardPath;
	}
	
	@GetMapping("/board_detail")
	public String boardDetail(@RequestParam(value = "boardId") Long boardId, Model model) throws Exception {
		Optional<Board> boardOptional = boardService.getBoardById(boardId);
		if (boardOptional.isPresent()) {
			Board board = boardOptional.get();
			model.addAttribute("board", board);
		}
		String forwardPath = "board_detail";
		return forwardPath;
	}
}

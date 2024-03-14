package com.formypet.jpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class BoardController {
	@GetMapping("/board_list")
	public String boardList() {
		String forwardPath = "board_list";
		return forwardPath;
	}
	
	@GetMapping("/board_write")
	public String boardWrite() {
		String forwardPath = "board_write";
		return forwardPath;
	}
	
	@GetMapping("/board_detail")
	public String boardDetail() {
		String forwardPath = "board_detail";
		return forwardPath;
	}
	@GetMapping("/elements")
	public String elements() {
		String forwardPath = "elements";
		return forwardPath;
	}
}

package com.formypet.jpa.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formypet.jpa.board.dto.BoardDto;
import com.formypet.jpa.board.entity.Board;
import com.formypet.jpa.board.entity.BoardCategory;
import com.formypet.jpa.board.entity.BoardSubCategory;
import com.formypet.jpa.board.repository.BoardCategoryRepository;
import com.formypet.jpa.board.repository.BoardRepository;
import com.formypet.jpa.board.repository.BoardSubCategoryRepository;
import com.formypet.jpa.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	@Autowired
	BoardSubCategoryRepository boardSubCategoryRepository;
	@GetMapping("/board_list/{categoryId}")
	public String boardList(@PathVariable(value = "categoryId") Long categoryId, Model model) throws Exception {
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
		model.addAttribute("subCategories", subCategories);
		List<Board> boards = boardService.getBoardByCategoryId(categoryId);
		model.addAttribute("boards", boards);
		String forwardPath = "board_list";
		return forwardPath;
	}
	@GetMapping("/board_list/{categoryId}/{subCategoryId}")
	public String subBoardList(@PathVariable(value = "categoryId") Long categoryId, @PathVariable(value = "subCategoryId", required = false) Long subCategoryId,  Model model) throws Exception {
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
		model.addAttribute("subCategories", subCategories);
		List<Board> subBoards = boardService.getBoardByCategoryIdAndSubCategoryId(categoryId, subCategoryId);
		model.addAttribute("subBoards", subBoards);
		String forwardPath = "board_list";
		return forwardPath;
	}

	@GetMapping("/board_detail")
	public String boardDetail(@RequestParam(value = "boardId") Long boardId, Model model) throws Exception {
		Board board = boardService.selectBoard(boardId);
		model.addAttribute("board", board);
		String forwardPath = "board_detail";
		return forwardPath;
	}

	/*
	 * @GetMapping("/board_list/{categoryId}") public ResponseEntity<List<String>>
	 * getSubCategoryNamesByMainCategoryId(@PathVariable Long categoryId) { try {
	 * List<String> subCategoryNames =
	 * boardSubCategoryServiceImpl.getSubCategoryNameByMainCategoryId(categoryId);
	 * if (subCategoryNames.isEmpty()) { return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<>(subCategoryNames, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	@GetMapping("/board_write/{categoryId}")
	public String boardWrite(@PathVariable(value = "categoryId") Long categoryId,Model model) throws Exception {
		BoardCategory boardCategory = boardService.getBoardCategoryByCategoryId(categoryId);
		model.addAttribute("boardCategory", boardCategory);
		List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
		model.addAttribute("subCategories", subCategories);
		String forwardPath = "board_write";
		return forwardPath;
	}

	@GetMapping("/board_adopt")
	public String boardAdopt(Model model) throws Exception {
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		List<BoardSubCategory> subCategories = boardSubCategoryRepository.findAll();
		model.addAttribute("subCategories", subCategories);
		String forwardPath = "board_list";
		return forwardPath;
	}

	@GetMapping("/test")
	public String test() {
		String forwardPath = "test";
		return forwardPath;
	}
	@GetMapping("/elements")
	public String elements() {
		String forwardPath = "elements";
		return forwardPath;
	}

}
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
import com.formypet.jpa.board.service.BoardService;
import com.formypet.jpa.board.service.BoardSubCategoryServiceImpl;

@Controller
@RequestMapping("/")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	@Autowired
	BoardSubCategoryServiceImpl boardSubCategoryServiceImpl;

	@GetMapping("/board_list")
	public String boardList(Model model) throws Exception {
		Long categoryId=1L;
		List<Board> boardListByCategory = boardService.getBoardByCategoryId(categoryId);
		model.addAttribute("boardListByCategory", boardListByCategory);
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		List<String> subCategories = boardSubCategoryServiceImpl.getSubCategoryNameByMainCategoryId(categoryId);
		model.addAttribute("subCategories",subCategories);
		
		String forwardPath = "board_list";
		return forwardPath;
	}
	
	@PostMapping("/api/board/create")
	public ResponseEntity<Board> createBoardForList(@RequestBody BoardDto boardDto) throws Exception {
	    Board board = boardService.createBoard(boardDto);
	    return new ResponseEntity<>(board, HttpStatus.CREATED);
	}	
/*
    @GetMapping("/board_list/{categoryId}")
    public ResponseEntity<List<String>> getSubCategoryNamesByMainCategoryId(@PathVariable Long categoryId) {
        try {
            List<String> subCategoryNames = boardSubCategoryServiceImpl.getSubCategoryNameByMainCategoryId(categoryId);
            if (subCategoryNames.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(subCategoryNames, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
	@GetMapping("/board_write")
	public String boardWrite(Model model) {
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		String forwardPath = "board_write";
		return forwardPath;
	}

	@GetMapping("/board_adopt")
	public String boardAdopt(Model model) throws Exception {
		Long categoryId=2L;
		List<Board> boardListByCategory = boardService.getBoardByCategoryId(categoryId);
		model.addAttribute("boardListByCategory", boardListByCategory);
		List<BoardCategory> categories = boardCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		String forwardPath = "board_list";
		return forwardPath;
	}
	
	@GetMapping("/test")
	public String test() {
		String forwardPath = "test";
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

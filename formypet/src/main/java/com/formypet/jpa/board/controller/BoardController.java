package com.formypet.jpa.board.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.formypet.jpa.board.entity.BoardReply;
import com.formypet.jpa.board.entity.BoardSubCategory;
import com.formypet.jpa.board.repository.BoardCategoryRepository;
import com.formypet.jpa.board.repository.BoardReplyRepository;
import com.formypet.jpa.board.repository.BoardRepository;
import com.formypet.jpa.board.repository.BoardSubCategoryRepository;
import com.formypet.jpa.board.service.BoardReplyService;
import com.formypet.jpa.board.service.BoardService;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import jakarta.servlet.http.HttpSession;
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
	@Autowired
	UserService userService;
	@Autowired
	BoardReplyService boardReplyService;

	@GetMapping("/board_list/{categoryId}")
	public String boardList(@PathVariable(value = "categoryId") Long categoryId, Model model, HttpSession session,
			@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
			@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "sorting", required = false) String sorting) throws Exception {
	    User loginUser = (User) session.getAttribute("loginUser");
	    if (loginUser != null) {
	        UserDto user = userService.findUser(loginUser.getUserId());
	        model.addAttribute("loginUser", user);
	    } else {
	        model.addAttribute("loginUser", null);
	    }
	    List<Board> searchedBoards = boardService.searchBoardByKeyword(keyword);
	    model.addAttribute("searchedBoards", searchedBoards);
	    List<BoardCategory> categories = boardCategoryRepository.findAll();
	    model.addAttribute("categories", categories);
	    List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
	    model.addAttribute("subCategories", subCategories);
	    Pageable pageable = PageRequest.of(page, size); // 페이지 및 사이즈 설정
	    Page<Board> boardPage;
	    if ("createdTimeDesc".equals(sorting)) {
	        boardPage = boardService.getAllBoardsSortedByCreatedTimeDescPaged(pageable); // 정렬하여 페이지 가져오기
	    } else {
	        boardPage = boardService.getBoardByCategoryIdPaged(categoryId, pageable); // 카테고리별 페이지 가져오기
	    }
	    model.addAttribute("boards", boardPage.getContent()); // 현재 페이지의 게시물 리스트
	    model.addAttribute("totalPages", boardPage.getTotalPages()); // 전체 페이지 수
	    model.addAttribute("currentPage", page); // 현재 페이지
	    List<String> subNames = boardService.getSubCategoryByCategoryId(categoryId);
	    model.addAttribute("subNames", subNames);
	    String forwardPath = "board_list";
	    return forwardPath;
	}

	@GetMapping("/board_list/{categoryId}/{subCategoryId}")
	public String subBoardList(@PathVariable(value = "categoryId") Long categoryId,
	        @PathVariable(value = "subCategoryId") Long subCategoryId, Model model, HttpSession session,
	        @RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "5") int size,
	        @RequestParam(value = "keyword", required = false) String keyword, 
	        @RequestParam(value = "sorting", required = false) String sorting) throws Exception {
	    User loginUser = (User) session.getAttribute("loginUser");
	    if (loginUser != null) {
	        UserDto user = userService.findUser(loginUser.getUserId());
	        model.addAttribute("loginUser", user);
	    } else {
	        model.addAttribute("loginUser", null);
	    }
	    List<Board> searchedBoards = boardService.searchBoardByKeyword(keyword);
	    model.addAttribute("searchedBoards", searchedBoards);
	    List<BoardCategory> categories = boardCategoryRepository.findAll();
	    model.addAttribute("categories", categories);
	    List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
	    model.addAttribute("subCategories", subCategories);
	    Pageable pageable = PageRequest.of(page, size); // 페이지 및 사이즈 설정
	    Page<Board> subBoardPage;
	    if ("createdTimeDesc".equals(sorting)) {
	        subBoardPage = boardService.getBoardsByCategoryIdAndSubCategoryIdSortedByCreatedTimeDescPaged(categoryId, subCategoryId, pageable);
	    } else {
	        subBoardPage = boardService.getBoardByCategoryIdAndSubCategoryIdPaged(categoryId, subCategoryId, pageable);
	    }
	    model.addAttribute("subBoards", subBoardPage.getContent()); // 현재 페이지의 게시물 리스트
	    model.addAttribute("totalPages", subBoardPage.getTotalPages()); // 전체 페이지 수
	    model.addAttribute("currentPage", page); // 현재 페이지
	    List<String> subCategoryNames = boardService.getSubCategoryName(subCategoryId);
	    model.addAttribute("subCategoryNames", subCategoryNames);
	    String subCategoryName = boardService.subCategoryNameBySubCategoryId(subCategoryId);
	    model.addAttribute("subCategoryName", subCategoryName);
	    String forwardPath = "board_list";
	    return forwardPath;
	}

	@GetMapping("/board_detail")
	public String boardDetail(@RequestParam(value = "boardId") Long boardId, Model model, HttpSession session)
			throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
			model.addAttribute("user", loginUser);
			UserDto user = userService.findUser(loginUser.getUserId());
			model.addAttribute("loginUser", user);
		} else {
			model.addAttribute("loginUser", null);
		}
		Optional<Board> optionalBoard = boardService.selectBoard(boardId);
		if (optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			model.addAttribute("board", board);
			User writerUserId = board.getUser();
			model.addAttribute("writerUserId", writerUserId);
		}
		boardService.increaseReadCount(boardId);
		List<BoardReply> replies = boardReplyService.findReplyByBoardId(boardId);
		model.addAttribute("replies",replies);
		
		String forwardPath = "board_detail";
		return forwardPath;
	}

	@GetMapping("/board_write/{categoryId}")
	public String boardWrite(@PathVariable(value = "categoryId") Long categoryId, Model model, HttpSession session)
			throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "redirect:/user_login_form";
		}
		UserDto user = userService.findUser(loginUser.getUserId());
		model.addAttribute("loginUser", user);
		BoardCategory boardCategory = boardService.getBoardCategoryByCategoryId(categoryId);
		model.addAttribute("boardCategory", boardCategory);
		List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
		model.addAttribute("subCategories", subCategories);
		String forwardPath = "board_write";
		return forwardPath;
	}

	@GetMapping("/board_update/{categoryId}/{boardId}")
	public String boardUpdate(@PathVariable(value = "categoryId") Long categoryId,
			@PathVariable(value = "boardId") Long boardId, Model model, HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
			UserDto user = userService.findUser(loginUser.getUserId());
			model.addAttribute("loginUser", user);
		} else {
			model.addAttribute("loginUser", null);
		}
		Optional<Board> optioanlBoard = boardService.selectBoard(boardId);
		if (optioanlBoard.isPresent()) {
			Board board = optioanlBoard.get();
			model.addAttribute("board", board);
		}
		BoardCategory boardCategory = boardService.getBoardCategoryByCategoryId(categoryId);
		model.addAttribute("boardCategory", boardCategory);
		List<BoardSubCategory> subCategories = boardService.getSubCategoryByCategoryBySubCategoryId(categoryId);
		model.addAttribute("subCategories", subCategories);
		String forwardPath = "board_update";
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
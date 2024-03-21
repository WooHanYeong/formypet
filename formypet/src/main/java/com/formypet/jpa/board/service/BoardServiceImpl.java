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

	// 메인 카테고리별 create 서비스
	@Override
	public Board createBoardByMainCategory(BoardDto boardDto) throws Exception {
		BoardCategory boardCategory = boardCategoryRepository.findById(boardDto.getBoardCategoryId())
				.orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));
		Board board = Board.builder().boardTitle(boardDto.getBoardTitle()).boardContent(boardDto.getBoardContent())
				.boardImage(boardDto.getBoardImage()).boardCategory(boardCategory).build();

		return boardRepository.save(board);
	}

	// 메인 카테고리의 서브카테고리별 create 서비스
	@Override
	public Board createBoardByMainCategoryBySubCategory(BoardDto boardDto) throws Exception {
		BoardCategory boardCategory = boardCategoryRepository.findById(boardDto.getBoardCategoryId())
				.orElseThrow(() -> new Exception("해당하는 카테고리가 존재하지 않습니다."));
		Optional<BoardSubCategory> boardSubCategoryOptional = boardSubCategoryRepository
				.findById(boardDto.getBoardSubCategoryId());
		BoardSubCategory boardSubCategory = boardSubCategoryOptional
				.orElseThrow(() -> new Exception("해당하는 서브 카테고리가 존재하지 않습니다."));
		Board board = Board.builder().boardTitle(boardDto.getBoardTitle()).boardContent(boardDto.getBoardContent())
				.boardImage(boardDto.getBoardImage()).boardCategory(boardCategory).boardSubCategory(boardSubCategory)
				.build();
		return boardRepository.save(board);
	}

	// boardId를 통한 게시글 삭제
	@Override
	public void deleteBoard(Long boardId) throws Exception {
		boardRepository.deleteById(boardId);
	}

	// boardId를 통한 게시글 업데이트
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

	// 게시글 모두 조회
	@Override
	public List<Board> getBoardByAll() throws Exception {
		return boardRepository.findAll();
	}

	// 게시글 상위 카테고리별 조회
	@Override
	public List<Board> getBoardByCategoryId(Long categoryId) throws Exception {
		return boardRepository.findByBoardCategoryCategoryId(categoryId);
	}

	// 게시글 상위카테고리 and 하위카테고리별 조회
	@Override
	public List<Board> getBoardByCategoryIdAndSubCategoryId(Long categoryId, Long subCategoryId) throws Exception {
		return boardRepository.findByBoardCategoryCategoryIdAndBoardSubCategorySubCategoryId(categoryId, subCategoryId);
	}

	// 페이지 서브 카테고리 표시
	@Override
	public List<BoardSubCategory> getSubCategoryByCategoryBySubCategoryId(Long categoryId) throws Exception {
		Optional<BoardCategory> optionalCategory = boardCategoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			BoardCategory category = optionalCategory.get();
			List<BoardSubCategory> subCategories = category.getSubCategories();
			return subCategories;
		}
		throw new Exception("서브카테고리를 찾을 수 없습니다.");
	}

	// 게시글 한개 조회
	@Override
	public Board selectBoard(Long boardId) throws Exception {
		Optional<Board> optionalBoard = boardRepository.findById(boardId);
		if (optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			return board;
		}
		throw new Exception("해당 게시글을 찾을 수 없습니다.");
	}

	// 상위 카테고리 조회
	@Override
	public BoardCategory getBoardCategoryByCategoryId(Long categoryId) throws Exception {
		Optional<BoardCategory> optionalCategory = boardCategoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			BoardCategory boardCategory = optionalCategory.get();
			return boardCategory;
		}
		throw new Exception("해당 카테고리를 찾을 수 없습니다.");
	}

	@Override
	public List<String> getSubCategoryName(Long subCategoryId) throws Exception {
		List<BoardSubCategory> subCategories = boardSubCategoryRepository.findBySubCategoryId(subCategoryId);
		List<String> subCategoryNames = new ArrayList<>();
		for (BoardSubCategory subCategory : subCategories) {
			subCategoryNames.add(subCategory.getSubCategoryName());
		}
		return subCategoryNames;

	}

	// 게시글에 속한 서브카테고리 id를 찾고 그 서브 카테고리의 id 값으 해당하는 값
	@Override
	public List<String> getSubCategoryByCategoryId(Long categoryId) throws Exception {
		List<Board> boards = boardRepository.findByBoardCategoryCategoryId(categoryId);
		System.out.println("boards" + boards);
		List<String> subCategoryNames = new ArrayList<>();
		for (Board board : boards) {
			Long subCategoryId = board.getBoardSubCategory().getSubCategoryId();
			Optional<BoardSubCategory> optionalSubCategory = boardSubCategoryRepository.findById(subCategoryId);
			if (optionalSubCategory.isPresent()) {
				BoardSubCategory subCategory = optionalSubCategory.get();
				if (subCategoryId == subCategory.getSubCategoryId()) {
					String subCategoryName = subCategory.getSubCategoryName();
					subCategoryNames.add(subCategoryName);
				}

			}
		}
		return subCategoryNames;
	}
	
    @Override
    public void increaseReadCount(Long boardId) throws Exception{
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setBoardReadCount(board.getBoardReadCount() + 1);
            boardRepository.save(board);
        } 
    }
    @Override
    public void updateRecommendCount(Long boardId, int recommendCount) throws Exception{
        Board board = boardRepository.findByBoardId(boardId);
        if (board != null) {
            board.setBoardRecommend(recommendCount);
            boardRepository.save(board);
            System.out.println("게시글의 추천 수가 업데이트되었습니다: " + recommendCount);
        } else {
            System.out.println("해당하는 게시글을 찾을 수 없습니다.");
        }
    }

}
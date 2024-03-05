package com.formypet.jpa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formypet.jpa.Exception.ExistedUserException;
import com.formypet.jpa.user.dao.UserDao;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.dto.UserLoginDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Operation(summary ="회원가입[성공]")
	@PostMapping(value = "/join")
	public ResponseEntity<?> user_write_action(@RequestBody UserDto userDto) throws Exception {
		try {
			if (userDao.existsById(userDto.getUserId())) {
				throw new ExistedUserException(">>>" + userDto.getUserId() + "는 이미 존재하는 아이디입니다.");
			}
			UserDto createdUser = userService.createUser(userDto);

			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (ExistedUserException e) {
			// 이미 존재하는 사용자 예외 처리
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// 기타 예외 처리
			return new ResponseEntity<>("Internal Server Error>> user_write_action 레스트 컨트롤러 작동하지만 기타예외로 납치됨",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "로그인 성공")
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<UserLoginDto> user_login_action(@RequestBody UserLoginDto userLogindto, HttpSession session)
			throws Exception {
		User loginUser = userService.loginUser(userLogindto.getUserId(), userLogindto.getUserPassword());

		if (loginUser != null) {
			// 로그인 성공 시 사용자 정보를 세션에 저장
	        session.setAttribute("loginUser", loginUser); // 사용자 객체를 세션에 저장

			return new ResponseEntity<UserLoginDto>(userLogindto, HttpStatus.OK);
		} else {
			// 로그인 실패 시 UNAUTHORIZED 상태 반환
			return new ResponseEntity<UserLoginDto>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
}

package com.formypet.jpa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Operation(summary = "회원가입[성공]")
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

	@Operation(summary = "로그인[성공]")
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

	@Operation(summary = "회원업데이트[성공]")
	@PutMapping(value = "/update/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> user_modify_action(@PathVariable(name = "userId") String userId,
			@RequestBody UserDto userUpdateDto, HttpSession session) {
		try {
			session.getAttribute("sUserId");

			UserDto updatedUser = userService.updateUser(userUpdateDto);

			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// 아이디, 전화번호로 비밀번호 찾기 API
	@Operation(summary = "아이디찾기[성공]")
	@GetMapping("/find/id")
	public ResponseEntity<String> findUserIdByUserNameAndBirthDate(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "userBirthDate") String userBirthDate) {
		try {
			String foundUserPw = userService.findUserIdByUserNameAndBirthDate(userName, userBirthDate);
			return new ResponseEntity<>(foundUserPw, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// 아이디, 전화번호로 비밀번호 찾기 API
	@Operation(summary = "비밀번호찾기[성공]")
	@GetMapping("/find/password")
	public ResponseEntity<String> findUserPasswordByUserIdNameAndBirthDate(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "userName") String userName ,@RequestParam(name = "userBirthDate") String userBirthDate) {
		try {
			String foundUserPw = userService.findUserPasswordByUserIdNameAndBirthDate(userId,userName, userBirthDate);
			return new ResponseEntity<>(foundUserPw, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//회원탈퇴
	@Operation(summary = "회원탈퇴") 
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> user_delete_action(@PathVariable(name = "userId") String userId, HttpSession session)
			throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		String loginUserId = loginUser.getUserId();
		userService.deleteUser(loginUserId);
		session.invalidate();

		return new ResponseEntity<>(HttpStatus.OK);
	}

}

package com.formypet.jpa.user.service;

import java.util.List;

import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;

public interface UserService {
	
	//회원가입
	UserDto createUser(UserDto userdto) throws Exception;
	
	//회원탈퇴
	void deleteUser(String userId) throws Exception;
	
	// 로그인
	User loginUser(String userId,String userPassword) throws Exception;
	
	//업데이트
	UserDto updateUser(UserDto userDto) throws Exception;
	
	//회원정보조회
	UserDto findUser(String userId) throws Exception;
	
	//이름과생년월일로 아이디 찾기
	String findUserIdByUserNameAndBirthDate(String userName, String userBirthDate) throws Exception;
	
	//아이디, 이름, 생년월일로 비밀번호찾기
	String findUserPasswordByUserIdNameAndBirthDate
				(String userId, String userName, String userBirthDate) throws Exception;
	
	//long값으로 유저정보 가져오기
	User findUserById(Long userId);
	
	//모든회원조회
	List<User> findByAllUser();
}

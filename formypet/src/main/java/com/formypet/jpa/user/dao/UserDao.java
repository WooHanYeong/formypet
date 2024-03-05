package com.formypet.jpa.user.dao;

import com.formypet.jpa.user.entity.User;


public interface UserDao {

	//회원가입
	User createUser(User user);
	
	//회원탈퇴
	void deleteUser(String userId) throws Exception;
	
	//업데이트
    User updateUser(User user) throws Exception;
    
    //회원찾기
    User findUser(String userId);

    //회원 중복체크
    boolean existsById(String userId); //중복된 아이디 체크
	
	//이름과생년월일로 아이디 찾기
	String findUserIdByUserNameAndBirthDate(String userName, String userBirthDate) throws Exception;
	
	//아이디, 이름, 생년월일로 비밀번호찾기
	String findUserPasswordByUserIdNameAndBirthDate
				(String userId, String userName, String userBirthDate) throws Exception;
	
}

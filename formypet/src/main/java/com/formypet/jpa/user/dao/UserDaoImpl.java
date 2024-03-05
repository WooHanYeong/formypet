package com.formypet.jpa.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepository;
	
	//회원가입
	@Override
	public User createUser(User user) {
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	//회원탈퇴
	@Override
	public void deleteUser(String userId) throws Exception {
		userRepository.deleteByUserId(userId);		
	}
	
	//회원수정
	@Override
	public User updateUser(User user) throws Exception {
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	//회원찾기
	@Override
	public User findUser(String userId) {
		User findedUser = userRepository.findByUserId(userId);
		return findedUser;
	}
	
	//회원 중복체크
	@Override
	public boolean existsById(String userId) {
		return userRepository.existsByUserId(userId);
	}
	//이름과생년월일로 아이디 찾기
	@Override
	public String findUserIdByUserNameAndBirthDate(String userName, String userBirthDate) throws Exception {
		String findUserId = userRepository.findUserIdByUserNameAndBirthDate(userName, userBirthDate);
		return findUserId;
	}
	//아이디, 이름, 생년월일로 비밀번호찾기
	@Override
	public String findUserPasswordByUserIdNameAndBirthDate(String userId, String userName, String userBirthDate)
			throws Exception {
		String findUserPassWord = userRepository.findUserPasswordByUserIdNameAndBirthDate(userId, userName, userBirthDate);
		return findUserPassWord;
	}

}

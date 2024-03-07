package com.formypet.jpa.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formypet.jpa.Exception.ExistedUserException;
import com.formypet.jpa.Exception.PasswordMismatchException;
import com.formypet.jpa.Exception.UserNotFoundException;
import com.formypet.jpa.user.dao.UserDao;
import com.formypet.jpa.user.dto.UserDto;
import com.formypet.jpa.user.entity.User;
import com.formypet.jpa.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	UserRepository userRepository;

	// 회원가입
	@Override
	public UserDto createUser(UserDto userDto) throws Exception {
		if (userDao.existsById(userDto.getUserId())) {
			throw new ExistedUserException(userDto.getUserId() + "는 이미 존재하는 아이디입니다.");
		}
		User createUser = userDao.createUser(User.toEntity(userDto));
		return UserDto.toDto(createUser);
	}

	// 회원탈퇴
	@Override
	public void deleteUser(String userId) throws Exception {
		userDao.deleteUser(userId);

	}

	// 로그인
	@Override
	public User loginUser(String userId, String userPassword) throws Exception {
		User user = userDao.findUser(userId);
		User fUser = User.builder().userId(userId).userPassword(userPassword).build();
		if (user == null) {
			UserNotFoundException exception = new UserNotFoundException(userId + " 는 존재하지않는 아이디입니다.");
			exception.setData(fUser);
			throw exception;
		}

		String userPw = user.getUserPassword();
		if (!userPw.equals(userPassword)) {
			PasswordMismatchException exception = new PasswordMismatchException("패쓰워드가 일치하지 않습니다.");
			exception.setData(fUser);
			throw exception;
		}
		return user;
	}

	// 회원수정
	@Override
	public UserDto updateUser(UserDto userDto) throws Exception {
		User user = userDao.findUser(userDto.getUserId());
		if (user == null) {
			throw new Exception("사용가자 존재하지 않습니다.");
		}

		user.setUserPassword(userDto.getUserPassword());
		user.setUserName(userDto.getUserName());
		user.setUserAddress(userDto.getUserAddress());
		user.setUserAddressDetail(userDto.getUserAddressDetail());
		user.setUserBirthDate(userDto.getUserBirthDate());

		User updateUser = userDao.updateUser(user);
		return UserDto.toDto(updateUser);
	}

	// 회원정보조회
	@Override
	public UserDto findUser(String userId) throws Exception {
		return UserDto.toDto(userDao.findUser(userId));
	}

	// 아이디찾기
	@Override
	public String findUserIdByUserNameAndBirthDate(String userName, String userBirthDate) throws Exception {
		if (userName == null || userName.isEmpty()) {
			throw new Exception("사용자 이름에대한 오류발생");
		}
		if (userBirthDate == null || userBirthDate.isEmpty()) {
			throw new Exception("사용자 생년월일에대한 오류발생");
		}
		String userId = userDao.findUserIdByUserNameAndBirthDate(userName, userBirthDate);
		if (userId == null) {
			throw new Exception("해당 사용자가 존재하지 않습니다.");
		}
		return userId;
	}

	// 비밀번호찾기
	@Override
	public String findUserPasswordByUserIdNameAndBirthDate(String userId, String userName, String userBirthDate)
			throws Exception {
		if (userId == null || userId.isEmpty()) {
			throw new Exception("사용자 아이디에대한 오류발생");
		}
		if (userName == null || userName.isEmpty()) {
			throw new Exception("사용자 이름에대한 오류발생");
		}
		if (userBirthDate == null || userBirthDate.isEmpty()) {
			throw new Exception("사용자 생년월일에대한 오류발생");
		}
		String userPassWord =userDao.findUserPasswordByUserIdNameAndBirthDate(userId, userName, userBirthDate);
		if(userPassWord ==null) {
			throw new Exception("해당정보로 등록된 사용자가 없습니다.");
		}
		return userPassWord;
	}

}

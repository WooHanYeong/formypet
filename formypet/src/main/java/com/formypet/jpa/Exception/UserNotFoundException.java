package com.formypet.jpa.Exception;

import com.formypet.jpa.user.entity.User;

public class UserNotFoundException extends RuntimeException {

    private User user; // 발생한 예외에 대한 정보를 저장할 사용자 객체

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // 예외 객체에 사용자 정보를 설정하는 메서드
    public void setData(User user) {
        this.user = user;
    }

    // 예외 객체에 설정된 사용자 정보를 반환하는 메서드
    public User getData() {
        return user;
    }
}


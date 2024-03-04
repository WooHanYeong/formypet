package com.formypet.jpa.user.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 여기에 로그아웃 시 수행할 작업을 추가합니다.
        // 예를 들어, 세션을 무효화하고 삭제하는 작업 등을 수행할 수 있습니다.
        request.getSession().invalidate(); // 세션 무효화

        // 로그아웃 후 리다이렉트 등의 작업을 수행할 수 있습니다.
        // response.sendRedirect("/logout-success");
    }
}

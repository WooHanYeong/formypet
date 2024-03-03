package com.formypet.jpa.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.formypet.jpa.user.dto.Role;
import com.formypet.jpa.user.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final LogoutHandler logoutHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrfConfig) -> csrfConfig.disable())
				.headers(
						(headerConfig) -> headerConfig.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
				.authorizeHttpRequests((authorizeRequest) -> authorizeRequest
						.requestMatchers("/posts/new", "/comments/save").hasRole(Role.USER.name())
						.requestMatchers("/", "/css/**", "images/**", "/js/**", "/login/*", "/logout/*", "/posts/**",
								"/comments/**")
						.permitAll().anyRequest().authenticated())
				// 로그아웃 설정
				.logout((logoutConfig) -> logoutConfig.logoutUrl("/logout") // 로그아웃 URL
													   .invalidateHttpSession(true)
													   .logoutSuccessUrl("/user_login_form") // 로그아웃 성공 시 이동할 URL
													   
				)
				// OAuth2 로그인 기능에 대한 여러 설정
				.oauth2Login(
						(oauth) -> oauth.userInfoEndpoint((endpoint) -> endpoint.userService(customOAuth2UserService)));

		return http.build();
	}
}

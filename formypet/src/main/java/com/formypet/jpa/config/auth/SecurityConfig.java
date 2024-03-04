package com.formypet.jpa.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.UserInfoEndpointConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.formypet.jpa.user.dto.Role;
import com.formypet.jpa.user.handler.CustomLogoutHandler;
import com.formypet.jpa.user.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {

		http
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement((sessionmanagment) 
						-> sessionmanagment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.formLogin(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorizeRequest) 
						-> authorizeRequest.requestMatchers(new MvcRequestMatcher(introspector, "api/user")).permitAll())
				.oauth2Login(oauth2Login
						-> oauth2Login.userInfoEndpoint(UserInfoEndpointConfig 
								->UserInfoEndpointConfig.userService(customOAuth2UserService)));

		return http.build();
	}
}

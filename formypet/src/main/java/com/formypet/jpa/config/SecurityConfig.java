/*
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * // 사용자 인증을 위한 설정
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication()
 * .withUser("user").password("password").roles("USER") .and()
 * .withUser("admin").password("password").roles("ADMIN"); }
 * 
 * // HTTP 보안을 위한 설정
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .antMatchers("/admin/**").hasRole("ADMIN") // /admin/**
 * 경로는 ADMIN 권한이 있어야 접근 가능 .anyRequest().authenticated() // 나머지 모든 요청은 인증이 필요함
 * .and() .formLogin().permitAll() // 로그인 페이지는 모두 접근 가능 .and()
 * .logout().permitAll(); // 로그아웃은 모두 접근 가능 }
 * 
 * // 패스워드 인코더 빈 설정
 * 
 * @Bean public PasswordEncoder passwordEncoder() { // 간단한 인코더인
 * NoOpPasswordEncoder를 사용 (실제 프로덕션에서는 사용하지 말 것) return
 * NoOpPasswordEncoder.getInstance(); } }
 */
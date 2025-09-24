package com.worms.userservice.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

/* 설명. Spring Security 모듈 추가 후 default 로그인 페이지 제거 및 인가 설정 */
@Configuration
public class WebSecurity {

    private JwtAuthenticationProvider jwtAuthenticationProvider;
    private Environment env;   // JWT Token의 payload에 만료시간 만들다가 추가함
    private JwtUtil jwtUtil;

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider
            , Environment env, JwtUtil jwtUtil) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.env = env;
        this.jwtUtil = jwtUtil;
    }

    /* 설명. 우리가 만든 프로바이더 bean으로 등록 */
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(authz ->
                authz.requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
        )

                /* 설명. Session 방식이 아닌 JWT Token 방식을 사용하겠다. */
                /* 설명. Session 방식이 아닌 JWT Token 방식으로 인증된 회원(Authentication)을 Local Thread로 저장하겠다. */
                .sessionManagement(session -> 
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        

        /* 설명. 매니저를 지닌 필터 등록 */
        http.addFilter(getAuthenticationFilter(authenticationManager()));

       /* 설명. 로그인 이후 토큰을 들고 온다면 JwtFilter를 추가해서 검증하도록 함 */
        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /* 설명. Filter를 등록하기 위해 사용하는 메소드 */
    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, env);
    }
}
package com.hobeom.shop.shop_server.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
@EnableWebSecurity  // Spring Security 설정을 활성화
public class SecurityConfig {

//    [기본 인증]
//    @Bean
//    public SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authz -> authz // 요청에 대한 보안 검사
//                        .anyRequest().authenticated() // 어떤 요청이든 인증되어야 함
//                ).httpBasic(
//                        Customizer.withDefaults()
//                ) // HTTP Basic 인증 사용
//                .build();
//    }

//    [formLogin() : 폼 로그인 사용]
//    @Bean
//    public SecurityFilterChain formSecurityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authz -> authz // 요청에 대한 보안 검사
//                        .anyRequest().authenticated() // 어떤 요청이든 인증되어야 함
//                ).formLogin(Customizer.withDefaults() // 폼 로그인 사용
//                ).build();
//    }

//    [OAuth2 로그인 사용]
//    @Bean
//    public SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authz -> authz // 요청에 대한 보안 검사
//                        .anyRequest().authenticated() // 어떤 요청이든 인증되어야 함
//                ).oauth2Login(Customizer.withDefaults() // OAuth2 로그인 사용
//                ).build();
//    }

//    [JWT 사용]
//    @Bean
//    public SecurityFilterChain jwtSecurityFilterChain(HttpSecurity http) throws Exception {
//         http
//                .authorizeHttpRequests(authz -> authz // 요청에 대한 보안 검사
//                        .anyRequest().authenticated() // 어떤 요청이든 인증되어야 함
//                ).addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
}

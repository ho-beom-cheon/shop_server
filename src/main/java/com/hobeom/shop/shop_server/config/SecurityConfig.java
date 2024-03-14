package com.hobeom.shop.shop_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // Spring Security 설정을 활성화
public class SecurityConfig {
   /* SecurityFilterChain 빈을 생성하여 필터를 구성한다.
    * HttpSecurity를 사용하여 필터를 구성한다.
    * authorizeRequests() 메서드를 사용하여 요청에 대한 접근 권한을 설정한다.
    * formLogin() 메서드를 사용하여 로그인 페이지와 로그인 처리 URL을 설정한다.
    * logout() 메서드를 사용하여 로그아웃 URL과 로그아웃 성공 URL을 설정한다.
    * csrf() 메서드를 사용하여 CSRF 보호를 비활성화한다.
    * build() 메서드를 사용하여 필터를 빌드하여 SecurityFilterChain 빈을 생성한다.
   * */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests(authorize -> authorize
//                        .anyRequest().authenticated())
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")               // 로그인 페이지 URL
//                        .loginProcessingUrl("/login") // 로그인 처리 URL
//                        .defaultSuccessUrl("/home", true)) // 로그인 성공 URL
//                .logout(logout -> logout
//                        .logoutUrl("/logout")                // 로그아웃 URL
//                        .logoutSuccessUrl("/login"))    //  로그아웃 성공 URL
//                .csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

    /*
    * BCryptPasswordEncoder 빈을 생성하여 비밀번호를 암호화한다.
    * BCryptPasswordEncoder는 BCrypt 해시 함수를 사용하여 비밀번호를 암호화한다.
    * getPasswordEncoder() 메서드를 사용하여 BCryptPasswordEncoder 빈을 생성한다.
    * */
    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

}

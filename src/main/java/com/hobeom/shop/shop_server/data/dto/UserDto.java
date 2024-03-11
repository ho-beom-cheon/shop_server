package com.hobeom.shop.shop_server.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor  //모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor   //기본 생성자
@Builder
public class UserDto {
    //아이디
    private long userId;
    //패스워드
    private String userPassword;
    //이름
    private String userName;
    //전화번호
    private String userPhone;
    //이메일
    private String userEmail;
    //닉네임
    private String userNickname;
    //프로필사진
    private String userProfile;
    //이메일수신여부
    private String emailCheck;
    //유저권한
    private int userRole;
    //등급
    private String userGrade;
    //가입날짜
    private LocalDate userInsertDate;

//    private int serviceCheck; // 서비스 이용동의
//    private int personalCheck; // 개인정보 이용동의
//    private int smsCheck; // sms 이용동의
//    private int emailCheck; // 이메일 이용동의
//    private int callCheck; // 전화 수신 동의

}

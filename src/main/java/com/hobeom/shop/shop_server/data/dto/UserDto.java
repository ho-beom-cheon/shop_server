package com.hobeom.shop.shop_server.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //getter, setter, toString, equals, hashCode를 자동으로 생성
@AllArgsConstructor  //모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor   //기본 생성자
public class UserDto {
    //아이디
    private String userId;
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
    private String userInsertDate;

}

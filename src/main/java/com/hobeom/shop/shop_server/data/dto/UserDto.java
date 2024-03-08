package com.hobeom.shop.shop_server.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

// setter 메소드의 경우 의도 파악과 객체를 변경 할 수 있는 상태가 되어 안전성을 보장하기 어렵기 때문에 사용을 지양함.
@Getter              //getter 메소드 생성
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
    private Date userInsertDate;

    public void setuserId(String userId){
        this.userId = userId;
    }
}

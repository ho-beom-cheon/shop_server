package com.hobeom.shop.shop_server.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.hobeom.shop.shop_server.data.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor  //모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor   //기본 생성자
@Builder
public class UserDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String nickname;

    private Set<AuthorityDto> authorityDtoSet;

    public static UserDto from(User user) {
        if(user == null) return null;

        return UserDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }

    /* user */

//    // 아이디
//    @NotBlank(message = "아이디는 필수 입력값입니다.")
//    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
//    private long userId;
//
//    // 패스워드
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
//    private String userPassword;
//
//    // 이름
//    private String userName;
//
//    // 전화번호
//    @NotBlank(message = "전화번호는 필수 입력값입니다.")
//    private String userPhone;
//
//    // 이메일
//    @NotBlank(message = "이메일은 필수 입력값입니다.")
//    @Email(message = "이메일 형식이 올바르지 않습니다.")
//    private String userEmail;
//
//    // 닉네임
//    @NotBlank(message = "닉네임은 필수 입력값입니다.")
//    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$" , message = "닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
//    private String userNickname;
//
//    // 프로필사진
//    private String userProfile;
//
//    //이메일수신여부
//    private String emailCheck;
//
//    //유저권한
//    private Role userRole;
//
//    //등급
//    private String userGrade;
//
//    // 상태
//    private UserStatus userStatus;
//
//    //가입날짜
//    private LocalDateTime userInsertDate;
//
//    /*userOrder*/
//    //주문번호
//    private int orderNumber;
//
//    //주문날짜
//    private String orderDate;
//
//    //배송자주소1(우편번호)
//    private String address1;
//
//    //배송자주소2(주소)
//    private String address2;
//
//    //배송자주소3(상세주소)
//    private String address3;
//
//    //수령자이름
//    private String receiverName;
//
//    //수령자전화번호
//    private String receiverPhone;
//
////    private int serviceCheck; // 서비스 이용동의
////    private int personalCheck; // 개인정보 이용동의
////    private int smsCheck; // sms 이용동의
////    private int emailCheck; // 이메일 이용동의
////    private int callCheck; // 전화 수신 동의

}

package com.hobeom.shop.shop_server.data.entity;

import com.querydsl.core.types.EntityPath;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity{
    @Id
    // 자동으로 생성되는 값 사용 시 IDENTITY 전략 사용 (MySQL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_pwd")
    private String userPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_profile")
    private String userProfile;

    @Column(name = "email_check")
    private String emailCheck;

    @Column(name = "user_role")
    private int userRole;

    @Column(name = "user_grade")
    private String userGrade;

    @CreatedDate
    private Date userInsertDate;

}


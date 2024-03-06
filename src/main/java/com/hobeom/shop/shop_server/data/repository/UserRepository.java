package com.hobeom.shop.shop_server.data.repository;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
//    List<UserEntity> findAll(); // 전체 조회
    UserEntity findByUserId(String userId); // 아이디로 조회
}

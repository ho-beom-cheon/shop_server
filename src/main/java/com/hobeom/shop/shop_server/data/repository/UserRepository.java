package com.hobeom.shop.shop_server.data.repository;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String>{
//    List<UserEntity> findAll(); // 전체 조회

    // 아이디로 조회
    UserEntity findByUserId(String userId);
}

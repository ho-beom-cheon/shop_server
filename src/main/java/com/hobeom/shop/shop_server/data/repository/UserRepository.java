package com.hobeom.shop.shop_server.data.repository;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
//    List<UserEntity> findAll(); // 전체 조회

    // 아이디로 조회
    Optional<UserEntity> findByUserId(long userId);

    // 등록
    UserEntity save(UserEntity userEntity);

    // 삭제
    void delete(UserEntity userEntity);
}

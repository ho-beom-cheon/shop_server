package com.hobeom.shop.shop_server.data.repository;

import com.hobeom.shop.shop_server.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll(); // 전체 조회
}

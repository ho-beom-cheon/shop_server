package com.hobeom.shop.shop_server.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    D, // 삭제
    Y  // 활성
}

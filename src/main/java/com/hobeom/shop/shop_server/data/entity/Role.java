package com.hobeom.shop.shop_server.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// 사용자 권한
public enum Role {
    Role_User, // 사용자
    Role_Admin // 관리자
}

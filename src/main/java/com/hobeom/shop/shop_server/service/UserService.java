package com.hobeom.shop.shop_server.service;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
        // 사용자 조회
        public void selectUser(UserDto userDto);
}

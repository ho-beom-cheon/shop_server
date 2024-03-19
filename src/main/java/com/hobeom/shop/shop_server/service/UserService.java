package com.hobeom.shop.shop_server.service;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
        // 사용자 조회
        public void selectUser(UserDto userDto);

        // 사용자 등록
        public void save(UserDto userDto);

        // 사용자 수정
        public void updateUser(UserDto userDto);

        // 사용자 삭제
        public void deleteUser(UserDto userDto);
}

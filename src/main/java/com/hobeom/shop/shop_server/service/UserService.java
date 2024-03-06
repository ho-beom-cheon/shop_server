package com.hobeom.shop.shop_server.service;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//로그
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
@Service // 서비스 빈으로 등록
public class UserService {
        private static final Logger logger = LoggerFactory.getLogger(UserService.class);

        // final로 선언된 필드의 생성자를 자동으로 생성
        private final UserRepository userRepository;

        // 사용자 조회
        public void selectUser(UserDto userDto) {
            logger.info("selectUser");
            UserEntity userEntity = userRepository.findById(userDto.getUserId()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 없습니다.")
            );
            logger.info("userEntity : " + userEntity);
        }
}

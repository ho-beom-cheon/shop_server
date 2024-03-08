package com.hobeom.shop.shop_server.service.Impl;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import com.hobeom.shop.shop_server.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service // 서비스 빈으로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
public class UserSeviceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    // 사용자 조회
    @Override
    public void selectUser(UserDto userDto){
        logger.info("selectUser");
        UserEntity userEntity = userRepository.findByUserId(userDto.getUserId());
    }

}

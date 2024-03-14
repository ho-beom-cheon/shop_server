package com.hobeom.shop.shop_server.service.Impl;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import com.hobeom.shop.shop_server.service.UserService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service // 서비스 빈으로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
public class UserSeviceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper ;
    UserEntity userEntity = new UserEntity();
    // 사용자 조회
    @Override
    public void selectUser(UserDto userDto) {
        logger.info("selectUser");
        List<UserEntity> userYn = userRepository.findByUserIdAndUserPassword(userDto.getUserId(), userDto.getUserPassword());

    }

    @Override
    @Transactional
    public void save(UserDto userDto) {
        logger.info("signUp");
        // 비밀번호 암호화
        userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));

        //  dto -> entity 변환
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);

        // 중복 회원 검증
        validateDuplicateUser(userEntity);

        // save를 호출하는 시점에 insert쿼리가 나간다.(flush가 이루어진다.)
        userRepository.save(userEntity);
    }

    // 사용자 수정
    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        logger.info("updateUser");
        UserEntity persistance = userRepository.findByUserId(userDto.getUserId()).orElseThrow(()
                -> new NoSuchElementException("해당 사용자가 없습니다."));
        persistance.setUserEmail("new@gmail.com");
    }

    // 사용자 삭제
    @Override
    @Transactional
    public void deleteUser(UserDto userDto) {
        logger.info("deleteUser");
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);

        userRepository.delete(userEntity);
    }

    // 중복 회원 검증
    private void validateDuplicateUser(UserEntity userEntity) {
        userRepository.findByUserId(userEntity.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}

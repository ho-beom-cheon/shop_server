package com.hobeom.shop.shop_server.service.Impl;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import com.hobeom.shop.shop_server.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.hobeom.shop.shop_server.data.entity.QUserEntity.userEntity;

@Service // 서비스 빈으로 등록
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 생성
public class UserSeviceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    UserEntity userEntity = new UserEntity();
    // 사용자 조회
    @Override
    public void selectUser(UserDto userDto){
        logger.info("selectUser");
        userRepository.findByUserId(userDto.getUserId());
    }

    @Override
    @Transactional
    public void signUp(UserDto userDto) {
        logger.info("signUp");
        logger.info("userDto보기 : " + userDto.toString());
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        validateDuplicateUser(userEntity);

        logger.info("userEntity보기 : " + userEntity.toString());

        // save를 호출하는 시점에 insert쿼리가 나간다.(flush가 이루어진다.)
        userRepository.save(userEntity);
    }

    // 사용자 수정
    @Override
    @Transactional
    public void updateUser(long userId, UserDto userDto) {
        logger.info("updateUser");
        UserEntity persistance = userRepository.findByUserId(userId).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자가 없습니다.");
        });
        persistance.setUserEmail("new@gmail.com");
    }

    // 사용자 삭제
    @Override
    @Transactional
    public void deleteUser(UserDto userDto) {
        logger.info("deleteUser");
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

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

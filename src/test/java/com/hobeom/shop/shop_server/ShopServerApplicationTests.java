package com.hobeom.shop.shop_server;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Transactional
class ShopServerApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void 저장하기() {
        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("hobeom");
        userEntity.setUserEmail("test@gmail.com");
        userEntity.setUserPassword("1234");
        userEntity.setUserPhone("010-1234-5678");
        userEntity.setUserNickname("hobeom");
        userEntity.setUserProfile("test");
        userEntity.setEmailCheck("Y");
        userEntity.setUserRole(1);
        userEntity.setUserGrade("VIP");
        userEntity.setUserInsertDate(LocalDate.parse("2021-08-01"));

        System.out.println("확인 : " + userEntity.getUserId());
        //when
        userRepository.save(userEntity);
        userRepository.flush();

        //then
        UserEntity findUser = userRepository.findByUserId(userEntity.getUserId()).get();
        Assertions.assertThat(findUser).isEqualTo(userEntity);

    }

}

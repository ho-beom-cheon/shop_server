package com.hobeom.shop.shop_server;

import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


@SpringBootTest
@RequiredArgsConstructor
class ShopServerApplicationTests {

    @Autowired // 테스트 대상이 되는 객체를 주입
    UserRepository userRepository;

    @Autowired // 테스트를 위한 가짜 객체를 만들어서 주입
    PasswordEncoder passwordEncoder;

    @Test
    void 암호화_테스트(){
        //given
        String testPw = "1111";
        String encodePw = passwordEncoder.encode(testPw);
        System.out.println("암호화된 비밀번호 : " + encodePw);
        //when
        boolean matches = passwordEncoder.matches(testPw, encodePw);
        //then
        Assertions.assertThat(matches).isTrue();
    }
    @Test
    void 저장하기() {
        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("hobeom");
        userEntity.setUserEmail("test@gmail.com");
        userEntity.setUserPassword(passwordEncoder.encode("1111"));
        userEntity.setUserPhone("010-1234-5678");
        userEntity.setUserNickname("hobeom");
        userEntity.setUserProfile("test");
        userEntity.setEmailCheck("Y");
        userEntity.setUserRole(1);
        userEntity.setUserGrade("VIP");
        userEntity.setUserInsertDate(LocalDate.parse("2021-08-01"));

        System.out.println("확인 : " + userEntity.toString());

        //when
        userRepository.save(userEntity);
        userRepository.flush();

        //then
        UserEntity findUser = userRepository.findByUserId(userEntity.getUserId()).get();
        Assertions.assertThat(findUser).isEqualTo(userEntity); // findUser와 userEntity가 같은지 비교 (같아야 성공)

    }

}

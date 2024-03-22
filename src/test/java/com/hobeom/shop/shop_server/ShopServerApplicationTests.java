package com.hobeom.shop.shop_server;

import com.hobeom.shop.shop_server.data.entity.Role;
import com.hobeom.shop.shop_server.data.entity.UserEntity;
import com.hobeom.shop.shop_server.data.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootTest
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
        UserEntity userEntity = UserEntity.builder()
                .userName("hobeom")
                .userEmail("test@gmail.com")
                .userPassword(passwordEncoder.encode("1111"))
                .userPhone("010-1234-5678")
                .userNickname("hobeom")
                .userProfile("test")
                .emailCheck("Y")
                .userRole(Role.Role_User)
                .userGrade("VIP")
                .userInsertDate(LocalDateTime.now())
                .build();

        System.out.println("확인 : " + userEntity.toString());

        //when
        userRepository.save(userEntity);
        userRepository.flush();

        //then
//        UserEntity findUser = userRepository.findByUserId(userEntity.getUserId()).get();
//        Assertions.assertThat(findUser).isEqualTo(userEntity); // findUser와 userEntity가 같은지 비교 (같아야 성공)

    }

}

package com.hobeom.shop.shop_server.controller;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired // 의존성 주입
    UserService userService;
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectUser(UserDto userdto) {
        String resStr = "";

        try {
            userdto.setUserId(userdto.getUserId());
            userdto.setUserPassword(userdto.getUserPassword()); //추후 암호화 복호화 처리 모듈  추가 예정
            userService.selectUser(userdto);
            resStr = "회원 조회 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }
    @PostMapping("/signup")
    public void registerUser(@RequestBody UserDto userdto) {
        try {
            userService.save(userdto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 회원 수정
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(UserDto userdto) {
        String resStr = "";

        try {
                userdto.setUserId(userdto.getUserId());
                userService.updateUser(userdto);

            resStr = "회원 수정 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(UserDto userdto) {
        String resStr = "";

        try {
            userdto.setUserId(userdto.getUserId());
            userService.deleteUser(userdto);
            resStr = "회원 삭제 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }
}

package com.hobeom.shop.shop_server.controller;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "회원 조회", description = "회원 조회 테스트 API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired // 의존성 주입
    UserService userService;
    @Parameter(name = "id",description = "userId", required = true)
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectUser(UserDto userdto, @RequestParam String id) {
        String resStr = "";

        try {
            userdto.setuserId(id);
            userService.selectUser(userdto);
            resStr = "회원 조회 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }


}

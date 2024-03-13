package com.hobeom.shop.shop_server.controller;

import com.hobeom.shop.shop_server.data.dto.UserDto;
import com.hobeom.shop.shop_server.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "USER ", description = "회원 테스트 API")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired // 의존성 주입
    UserService userService;
    @Operation(summary = "회원 조회", description = "회원을 조회합니다.")
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

    @Operation(summary = "회원 가입"   , description = "새로운 회원을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 가입 완료"),
            @ApiResponse(responseCode = "400", description = "회원 가입 실패")
    })
    @Parameter(name = "userId"        ,description = "userId"        , required = true)
    @Parameter(name = "userPassword"  ,description = "userPassword"  )
    @Parameter(name = "userName"      ,description = "userName"      )
    @Parameter(name = "userPhone"     ,description = "userPhone"     )
    @Parameter(name = "userEmail"     ,description = "userEmail"     )
    @Parameter(name = "userNickname"  ,description = "userNickname"  )
    @Parameter(name = "userProfile"   ,description = "userProfile"   )
    @Parameter(name = "emailCheck"    ,description = "emailCheck"    , required = true)
    @Parameter(name = "userRole"      ,description = "userRole"      )
    @Parameter(name = "userGrade"     ,description = "userGrade"     )
    @PostMapping("/signup")
    public String registerUser(
        @RequestBody UserDto userdto,
        /* swagger 회원가입 테스트 */
        @RequestParam Long userId,
        @RequestParam String userPassword,
        @RequestParam String userName,    @RequestParam String userPhone,
        @RequestParam String userEmail,   @RequestParam String userNickname,
        @RequestParam String userProfile,
        @RequestParam String emailCheck,
        @RequestParam int userRole,       @RequestParam String userGrade
    ) {
        try {
            /* swagger 회원가입 테스트 */
            userdto.setUserId(userId);
            userdto.setUserPassword(userPassword);
            userdto.setUserName(userName);
            userdto.setUserPhone(userPhone);
            userdto.setUserEmail(userEmail);
            userdto.setUserNickname(userNickname);
            userdto.setUserProfile(userProfile);
            userdto.setEmailCheck("Y");
            userdto.setUserRole(userRole);
            userdto.setUserGrade(userGrade);

            logger.info("회원가입 테스트 : " + userdto.toString());

            userService.signUp(userdto);
            return "회원 가입 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // 회원 수정
    @Operation(summary = "회원 수정", description = "회원을 수정합니다.")
    @Parameter(name = "userId"        ,description = "userId"        , required = true)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(UserDto userdto, @RequestParam int userId) {
        String resStr = "";

        try {
            userService.updateUser(userId, userdto);

            resStr = "회원 수정 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }

    @Operation(summary = "회원 삭제", description = "회원을 삭제합니다.")
    @Parameter(name = "id",description = "userId", required = true)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(UserDto userdto, @RequestParam int id) {
        String resStr = "";

        try {
            userdto.setUserId(id);
            userService.deleteUser(userdto);
            resStr = "회원 삭제 완료\n" + "id : [" + userdto.getUserId() + "]";
        } catch (Exception e) {
            resStr = e.getMessage();
        }

        return resStr;
    }
}

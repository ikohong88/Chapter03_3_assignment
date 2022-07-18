package com.sparta.week03_3.controller;

import com.sparta.week03_3.dto.SignupRequestDto;
import com.sparta.week03_3.dto.UserInfoDto;
import com.sparta.week03_3.model.UserRoleEnum;
import com.sparta.week03_3.security.UserDetailsImpl;
import com.sparta.week03_3.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // 사용자 정보 불러오기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        System.out.println("username = " + username);
        UserRoleEnum role = userDetails.getUser().getRole();
        boolean isAdmin = (role == UserRoleEnum.ADMIN);
        boolean isOwner = (role == UserRoleEnum.OWNER);

        return new UserInfoDto(username, isAdmin, isOwner);
    }

    // 회원 가입
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }
}

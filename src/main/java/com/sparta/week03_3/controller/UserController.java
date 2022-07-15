package com.sparta.week03_3.controller;

import com.sparta.week03_3.dto.SignupRequestDto;
import com.sparta.week03_3.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }
    
    // 로그인
    @PostMapping("/user/login")
    public void login() {
        
    }
}

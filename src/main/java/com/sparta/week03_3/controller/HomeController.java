package com.sparta.week03_3.controller;

import com.sparta.week03_3.model.UserRoleEnum;
import com.sparta.week03_3.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());

            if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
                model.addAttribute("admin_role", true);
            }
            else if (userDetails.getUser().getRole() == UserRoleEnum.OWNER) {
                model.addAttribute("owner_role", true);
            }
        }
        return "index";
    }

    // 로그인 화면
    @GetMapping("/user/loginView")
    public String login() {
        return "login";
    }
    
    // 사용자 회원 가입
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }
    
    // 점포 등록 화면
    @GetMapping("/restaurant/registration")
    public String restaurantRegistration() {
        return "restaurantRegister";
    }

    // 점포 음식 등록 화면
    @GetMapping("/restaurant/food/registration")
    public String foodRegistration() {
        return "foodRegister";
    }


    //- 메뉴판 조회
//    - 하나의 음식점에 등록된 모든 음식 정보 조회
//        1. 등록 시 입력한 음식 정보 (name, price)
//        2. DB 테이블 ID (id)
    @GetMapping("/restaurant/{restaurantId}/foods")
    public String searchFood(@PathVariable String restaurantId) {
        return "menu";
    }
}

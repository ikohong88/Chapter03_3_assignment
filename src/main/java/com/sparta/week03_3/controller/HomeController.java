package com.sparta.week03_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/restaurant/registration")
    public String restaurantRegistration() {
        return "restaurant";
    }
}

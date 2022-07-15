package com.sparta.week03_3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String password_check;
    private boolean admin = false;
    private String adminToken = "";
}

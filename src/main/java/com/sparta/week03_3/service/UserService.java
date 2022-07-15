package com.sparta.week03_3.service;

import com.sparta.week03_3.dto.SignupRequestDto;
import com.sparta.week03_3.model.User;
import com.sparta.week03_3.model.UserRoleEnum;
import com.sparta.week03_3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;

    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);

        // 닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성하기
        String check_username = "^([a-zA-Z0-9]{3,})$";
        // 비밀번호는 최소 4자 이상
        String check_password_len = "^([a-zA-Z0-9]{4,})$";

        UserRoleEnum role = UserRoleEnum.USER;

        String password = requestDto.getPassword();
        String password_check = requestDto.getPassword_check();

        String result = "";

        if (!Pattern.matches(check_username, username)) {
            throw new IllegalArgumentException("닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성되어야 합니다.");
        }
        else if(!Pattern.matches(check_password_len, password)) {
            throw new IllegalArgumentException("비밀번호는 최소 4자 이상 되어야 합니다.");
        }
        else if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        // 닉네임과 같은 값이 포함된 경우 회원가입에 실패로 만들기
        else if (username.equals(password)) {
            throw new IllegalArgumentException("닉네임과 비밀번호가 같으면 안됩니다.");
        }
        // 패스워드 일치 확인
        else if (!password.equals(password_check)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 사용자 ROLE 확인
        else if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        // 패스워드 암호화
//        password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username, password, role);
        userRepository.save(user);

        result = "회원가입이 정상적으로 되었습니다.";

        return result;
    }
}

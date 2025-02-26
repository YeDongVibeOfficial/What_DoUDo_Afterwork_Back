package afterwork.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
//사용자 계정 관리
public class UserController {
    @PostMapping("/signup")
    public String signUp() {
        return "회원가입 완료";
    }

    @PostMapping("/login")
    public String login() {
        return "로그인 성공";
    }
}

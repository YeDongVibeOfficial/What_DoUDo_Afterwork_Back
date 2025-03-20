package afterwork.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import afterwork.backend.model.UserRequest;
import afterwork.backend.model.UserResponse;
import afterwork.backend.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 로그인 페이지
    @GetMapping("/login")
    public String openLogin() {
        return "users/login";
    }

    // 회원 정보 저장 (회원가입)
    @PostMapping("/users")
    @ResponseBody
    public Long saveMember(@RequestBody final UserRequest params) {
        return userService.saveMember(params);
    }

    // 회원 상세정보 조회
    @GetMapping("/users/{loginId}")
    @ResponseBody
    public UserResponse findMemberByLoginId(@PathVariable final String loginId) {
        return userService.findMemberByLoginId(loginId);
    }

    // 회원 정보 수정
    @PatchMapping("/users/{id}")
    @ResponseBody
    public Long updateMember(@PathVariable final Long id, @RequestBody final UserRequest params) {
        return userService.updateMember(params);
    }

    // 회원 정보 삭제 (회원 탈퇴)
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public Long deleteMemberById(final Long id) {
        return userService.deleteMemberById(id);
    }

    // // 회원 수 카운팅 (ID 중복 체크)
    // @GetMapping("/member-count")
    // @ResponseBody
    // public int countMemberByLoginId(@RequestParam final String loginId) {
    //     return userService.countMemberByLoginId(loginId);
    // }

}

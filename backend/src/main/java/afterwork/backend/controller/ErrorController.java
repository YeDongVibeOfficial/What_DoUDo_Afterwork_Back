package com.afterwork365.sbb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//에러 관리
@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/not-found")
    public String handleNotFound() {
        return "404 에러 - 페이지를 찾을 수 없습니다.";
    }

    @GetMapping("/server-error")
    public String handleServerError() {
        return "500 에러 - 서버 오류 발생.";
    }

    @GetMapping("/server-mollayo-error")
    public String getMethodName(@RequestParam String param) {
        return "머선 오류인지 모름";
    }
    
}

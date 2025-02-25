package com.afterwork365.sbb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//위치 기반 맞춤 추천
@RestController
@RequestMapping("/recomend")
public class RecommendationController {
    @PostMapping("/location")
    public String getLoacationRecommendations(@RequestBody String entity) {
        return "위치기반 추천";
    }
    @PostMapping("/custom")
    public String getCustomRecommendations(@RequestBody String customConditions) {
        return "사용자 조건 기반 추천 반환";
    }
    
}

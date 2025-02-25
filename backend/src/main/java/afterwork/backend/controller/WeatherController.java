package com.afterwork365.sbb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//날씨 관련 정보 요청 처리
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @GetMapping("/current")
    public String getCurrentWeather() {
        return "현재 날씨 정보";
    }

    @GetMapping("/forecast")
    public String getWeatherForecast() {
        return "날씨 예보 정보";
    }
    
}

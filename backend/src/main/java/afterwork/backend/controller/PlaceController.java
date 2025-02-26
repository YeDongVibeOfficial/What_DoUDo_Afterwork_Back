package afterwork.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//장소 조회
@RestController
@RequestMapping("/place")
public class PlaceController {
    @GetMapping("/all")
    public String getAllPlace() {
        return "전체 장소 조회";
    }

    @GetMapping("/details/{id}")
    public String getMethodName(@RequestParam String param) {
        return "상세 조회";
    }
    

}

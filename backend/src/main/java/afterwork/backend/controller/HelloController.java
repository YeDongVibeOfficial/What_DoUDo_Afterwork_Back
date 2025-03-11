package afterwork.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@Tag(name = "테스트 API", description = "Swagger 테스트용 컨트롤러")
public class HelloController {

    @Operation(summary = "Hello API", description = "Hello 문자열을 반환합니다.")
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello 지은s";
    }
}

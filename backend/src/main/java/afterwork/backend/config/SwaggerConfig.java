package afterwork.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration //설정파일임을 나타냄.
public class SwaggerConfig {

    @Bean //설정정보를 스프링빈으로 등록
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AfterWork365 API") //API 명세서 제목
                        .version("1.0.0") //버전
                        .description("퇴근 후 할 일을 추천하는 API 문서") //설명
                );
    }
}

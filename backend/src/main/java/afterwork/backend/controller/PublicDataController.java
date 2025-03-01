// 클라이언트의 요청 받고 응답 반환.
// 데이터를 DB에서 가져오거나 가공해서 Front에 보냄.

package afterwork.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import afterwork.backend.service.PublicDataApiService;

import afterwork.backend.dto.PublicDataDto;
import afterwork.backend.service.PublicDataService;

import org.springframework.web.bind.annotation.PostMapping;



@RestController // API 요청을 받을 클래스임을 명시.
@RequestMapping("/public-data") //이 경로로 오는 요청을 처리
public class PublicDataController {
    private final PublicDataService publicDataApiService;

    public PublicDataController(PublicDataService publicDataService) {
        this.publicDataApiService = publicDataApiService;
    }


    // 공공데이터 API 호출 및 저장 -> POST / public-data/fetch 요청 받으면 API 호출하여 데이터 가져온 후 DB에 저장
    @PostMapping("/fetch")
    public List<PublicDataDto> fetchAndSavePublicData() {
        return publicDataApiService.fetchAndSavePublicData();
    }
    
}

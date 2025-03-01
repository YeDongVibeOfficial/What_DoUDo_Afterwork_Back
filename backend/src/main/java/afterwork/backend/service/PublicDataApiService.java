package afterwork.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import afterwork.backend.dto.PublicDataDto;
import afterwork.backend.mapper.PublicDataMapper;

@Service
public class PublicDataApiService {
    private final RestTemplate restTemplate;
    private final PublicDataMapper publicDataMapper;

    private final String API_URL = "http://apis.data.go.kr/B551011/KorService1";
    //디코딩키
    private final String SERVICE_KEY = "VVOmSStfN2wJSHEf+dtpJXmiBOUek6SBLCa3ue+fX1qCYUMmwRU13VFK6bcrNTm6XpOMTYs1Z77cRmRno+Yqkg==";

    public PublicDataApiService(RestTemplate restTemplate, PublicDataMapper publicDataMapper) {
        this.restTemplate = restTemplate;
        this.publicDataMapper = publicDataMapper;
    }

    public List<PublicDataDto> fetchAndSavePublicData () {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
    }
}

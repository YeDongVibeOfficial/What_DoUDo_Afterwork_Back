package afterwork.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import afterwork.backend.mapper.PublicDataMapper;

@Service
public class PublicDataApiService {
    private final RestTemplate restTemplate;
    private final PublicDataMapper publicDataMapper;

    private final String API_URL = "http://apis.data.go.kr/B551011/KorService1";
    private final String SERVICE_KEY = "VVOmSStfN2wJSHEf%2BdtpJXmiBOUek6SBLCa3ue%2BfX1qCYUMmwRU13VFK6bcrNTm6XpOMTYs1Z77cRmRno%2BYqkg%3D%3D";

    public PublicDataApiService(RestTemplate restTemplate, PublicDataMapper publicDataMapper) {
        this.restTemplate = restTemplate;
        this.publicDataMapper = publicDataMapper;
    }
}

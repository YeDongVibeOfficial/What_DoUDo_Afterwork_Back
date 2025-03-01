// 데이터를 가공하거나 여러 개의 데이터를 합쳐서 새로운 데이터를 만들때 사용.
// Controller와 Repository(DB 접근 객체) 사이에서 중간 역할함.

package afterwork.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import afterwork.backend.dto.PublicDataDto;
import afterwork.backend.mapper.PublicDataMapper;
import afterwork.backend.model.PublicData;

@Service
public class PublicDataService {
    private final PublicDataMapper publicDataMapper;
    private final RestTemplate restTemplate;

    public PublicDataService(PublicDataMapper publicDataMapper) {
        this.publicDataMapper = publicDataMapper;
        this.restTemplate = new RestTemplate();
    }

    public void fetchAndSavePublicData() {
        String apiUrl = "https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15101578&serviceKey=YOUR_SERVICE_KEY&type=json";
        PublicDataDTO[] response = restTemplate.getForObject(apiUrl, PublicDataDTO[].class);

        if (response != null) {
            List<PublicDataDTO> dataList = List.of(response);
            dataList.stream().limit(20).forEach(dto -> {
                PublicData data = new PublicData();
                data.setName(dto.getPlName());
                data.setAddrBasic(dto.getPlAddrBasic());
                data.setAddrDetail(dto.getPlAddrDetail());
                data.setImgUrl(dto.getPlImgUrl());
                data.setNumber(dto.getPlNumber());
                data.setMapX(dto.getPlMapX());
                data.setMapY(dto.getPlMapY());
                data.setDistance(dto.getPlDistance());

                publicDataMapper.insertPublicData(data);
            });



    // public List<PublicDataDto> getPublicDataDtos() { //DB에서 데이터를 가져와 DTO로 변환 후 반환.
    //     List<PublicData> publicDataList = publicDataMapper.getAllPublicData();

    //     //Model -> DTO 로 변환
    //     return publicDataList.stream()
    //     .map(data -> new PublicDataDto(data.getPL_Name(), data.getPL_Addr_Basic(), data.getPL_Img_URL(), data.getPL_Distance()))
    //     .collect(Collectors.toList());

    // }
}

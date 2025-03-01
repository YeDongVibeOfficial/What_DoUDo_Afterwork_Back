package afterwork.backend.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import afterwork.backend.dto.TourDTO;
import afterwork.backend.service.TourService;

@RestController
public class OpenApiController {
    private final TourService tourService;

    public OpenApiController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour/save")
    public String callAndSaveApi(@RequestParam(value = "areaCode", required = false) Integer areaCode) {
        StringBuilder result = new StringBuilder();

        try {
            String apiUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?" +
                    "serviceKey=VVOmSStfN2wJSHEf%2BdtpJXmiBOUek6SBLCa3ue%2BfX1qCYUMmwRU13VFK6bcrNTm6XpOMTYs1Z77cRmRno%2BYqkg%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&_type=json";

            if (areaCode != null) {
                apiUrl += "&areaCode=" + areaCode;
            }

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            urlConnection.disconnect();

            // JSON 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(result.toString());
            JsonNode items = rootNode.path("response").path("body").path("items").path("item");

            List<TourDTO> tourList = new ArrayList<>();

            for (JsonNode item : items) {
                TourDTO tourDTO = new TourDTO();
                tourDTO.setPlcode(item.path("areacode").asInt());
                tourDTO.setPlTitle(item.path("title").asText());
                tourDTO.setPlAddrBasic(item.path("addr1").asText(""));
                tourDTO.setPlAddrDetail(item.path("addr2").asText(""));
                tourDTO.setPlTel(item.path("tel").asText(""));
                tourDTO.setPlImg(item.path("firstimage").asText(""));
                tourDTO.setPlMapX(item.path("mapx").asDouble());
                tourDTO.setPlMapY(item.path("mapy").asDouble());

                tourList.add(tourDTO);
            }

            // 변환된 데이터를 H2 DB에 저장
            for (TourDTO tourDTO : tourList) {
                tourService.saveTourInfo(tourDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "API 호출 실패!";
        }

        return "API 데이터 저장 완료!";
    }
}

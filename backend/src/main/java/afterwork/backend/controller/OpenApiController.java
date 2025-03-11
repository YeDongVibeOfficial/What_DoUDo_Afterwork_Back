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

import afterwork.backend.domain.TourDomain;
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
                    "&numOfRows=10000" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&_type=json" + 
                    "&arrange=C"; // 수정일순으로 정렬하여 최근데이터 순으로 받기

            if (areaCode != null) {
                apiUrl += "&areaCode=" + areaCode;
            }

            //URL 객체 생성하여 API 요청
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            //BufferedReader 사용하여 데이터 UTF-8로 받음 -> 한글때문ㅇ
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

            List<TourDomain> tourList = new ArrayList<>();

            for (JsonNode item : items) {
                // 각 항목에 값이 없으면 건너뛰기
                String title = item.path("title").asText("");
                String addr1 = item.path("addr1").asText("");
                String tel = item.path("tel").asText("");
                String firstImage = item.path("firstimage").asText("");
                double mapX = item.path("mapx").asDouble(Double.NaN);
                double mapY = item.path("mapy").asDouble(Double.NaN);

                // 필수 필드 중 하나라도 비어 있으면 건너뜀
                if (title.isEmpty() || addr1.isEmpty() || firstImage.isEmpty() || tel.isEmpty() || Double.isNaN(mapX) || Double.isNaN(mapY)) {
                    continue; // 빈 값이 있으면 건너뜀
                }
                // plTel이 50자 이상이면 이 항목을 건너뜀
                if (tel.length() > 50) {
                    continue;  // 50자 이상이면 저장하지 않고 건너뜀
                }


                TourDomain tourDTO = new TourDomain();
                tourDTO.setPlcode(item.path("areacode").asInt());
                tourDTO.setPlTitle(title);
                tourDTO.setPlAddrBasic(addr1);
                tourDTO.setPlAddrDetail(item.path("addr2").asText(""));
                tourDTO.setPlTel(tel);
                tourDTO.setPlImg(firstImage);
                tourDTO.setPlMapX(mapX);
                tourDTO.setPlMapY(mapY);

                tourList.add(tourDTO);
            }

            // 변환된 데이터를 H2 DB에 저장
            for (TourDomain tourDTO : tourList) {
                tourService.saveTourInfo(tourDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "API 호출 실패!";
        }

        return "API 데이터 저장 완료!";
    }
}
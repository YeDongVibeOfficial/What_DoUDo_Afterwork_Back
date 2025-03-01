// 클라이언트와 데이터를 주고받는 객체
package afterwork.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicDataDto {
    private String PL_Name;
    private String PL_Addr_Basic;
    private String PL_Img_URL;
    private Double PL_Distance;

    public PublicDataDto(String PL_Name, String PL_Addr_Basic, String PL_Img_URL, Double PL_Distance) {
        this.PL_Name = PL_Name;
        this.PL_Addr_Basic = PL_Addr_Basic;
        this.PL_Img_URL = PL_Img_URL;
        this.PL_Distance = PL_Distance;
    }

    
}

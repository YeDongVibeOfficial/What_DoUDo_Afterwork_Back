// 클라이언트와 데이터를 주고받는 객체
package afterwork.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicDataDto {
    
    private Long PL_Id;
    private String PL_Name;
    private String PL_Addr_Basic;
    private String PL_Addr_Detail;
    private String PL_Img_URL;
    private String PL_Number;
    private Double PL_Map_X;
    private Double PL_Map_y;
    private Double PL_Distance;

    
}

//myBatis에서 DB랑 연결될 떄 사용되는 클래스

package afterwork.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor //모든 필드 포함한 생성자 자동 생성

public class PublicData {
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

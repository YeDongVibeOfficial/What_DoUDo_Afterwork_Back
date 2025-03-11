package afterwork.backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourDomain {
    //plkey
    private Long id;
    //지역코드
    private int plcode;
    //title
    private String plTitle;
    //addr1
    private String plAddrBasic;
    //addr2
    private String plAddrDetail;
    //tel
    private String plTel;
    //firstimage
    private String plImg;
    //mapx
    private Double plMapX;
    //mapy
    private Double plMapY;


}

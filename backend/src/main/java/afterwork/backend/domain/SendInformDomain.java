package afterwork.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendInformDomain {
    private int plcode;
    private String plTitle;
    private String plAddrBasic;
    private String plAddrDetail;
    private String plTel;
    private String plImg;
    private double plMapX;
    private double plMapY;
}

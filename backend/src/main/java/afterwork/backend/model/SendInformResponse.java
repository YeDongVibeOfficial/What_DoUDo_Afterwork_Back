package afterwork.backend.model;

import java.util.List;

import afterwork.backend.domain.SendInformDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendInformResponse {

    private String status;
    private List<SendInformDomain> data;

    // public SendInformResponse(String status, List<SendInformDomain> data) {
    //     this.status = status;
    //     this.data = data;
    // }

    // public String getStatus() {
    //     return status;
    // }

    // public void setStatus(String status) {
    //     this.status = status;
    // }

    // public List<SendInformDomain> getData() {
    //     return data;
    // }

    // public void setData(List<SendInformDomain> data) {
    //     this.data = data;
    // }
}

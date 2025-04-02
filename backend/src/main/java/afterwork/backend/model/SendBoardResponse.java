package afterwork.backend.model;

import java.util.List;

import afterwork.backend.domain.BoardDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendBoardResponse {
    private String status;
    private List<BoardDomain> data;
}

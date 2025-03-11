package afterwork.backend.domain;

import java.time.LocalDateTime;

public class BoardDomain {
    private Long boardId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createDate;
    private int readCnt;
    private Long memberId;
}

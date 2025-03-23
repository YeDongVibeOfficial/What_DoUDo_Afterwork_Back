package afterwork.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;                       // 회원 번호 (PK)
    private String loginId;                // 로그인 ID
    private String password;               // 비밀번호
    private String name;                   // 이름
    private Gender gender;                 // 성별
    private LocalDate birthday;            // 생년월일
    private LocalDateTime createdDate;     // 생성일시

    public void clearPassword() {
        this.password = "";
    }

}
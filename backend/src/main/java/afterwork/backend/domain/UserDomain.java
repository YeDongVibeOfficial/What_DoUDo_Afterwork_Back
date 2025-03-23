package afterwork.backend.domain;

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
public class UserDomain {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private char gender;
    private LocalDate birthday;
    private LocalDateTime createdDate;
}

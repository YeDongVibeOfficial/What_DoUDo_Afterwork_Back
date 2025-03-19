package afterwork.backend.domain;

import java.time.LocalDate;

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
    private String userId;
    private String password;
    private String name;
    private String gender;
    private LocalDate birthday;
    private LocalDate createDate;
}

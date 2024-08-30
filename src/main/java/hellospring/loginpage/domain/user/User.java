package hellospring.loginpage.domain.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class User {
    private Long id;

    @NotEmpty
    private String loginId; //시스템 내부적으로 사용하는 사용자의 로그인 ID
    @NotEmpty
    private String name; //사용자 이름
    @NotEmpty
    private String password;
}

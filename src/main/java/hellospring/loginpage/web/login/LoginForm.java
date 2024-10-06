package hellospring.loginpage.web.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String userPassword;

}

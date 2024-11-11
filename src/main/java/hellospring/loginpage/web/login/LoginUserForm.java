package hellospring.loginpage.web.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginUserForm {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String userPassword;

}

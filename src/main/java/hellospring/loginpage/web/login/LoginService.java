package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;


    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

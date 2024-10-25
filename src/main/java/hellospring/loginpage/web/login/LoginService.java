package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.User;
import hellospring.loginpage.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;


    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String loginId, String password) {
        Optional<User> optionalMember = userRepository.findByLoginId(loginId);
        if (optionalMember.isPresent()) {
            User user = optionalMember.get();
            if (user.getPassword().equals(password)) {
                return user; // 로그인 성공
            }
        }
        return null; // 로그인 실패
    }


}

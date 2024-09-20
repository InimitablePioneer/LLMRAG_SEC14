package hellospring.loginpage.webcontroller;

import hellospring.loginpage.domain.user.User;
import hellospring.loginpage.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/")
public class UserController {


    private final UserRepository userRepository;

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute(new User());
        return "users/addUserForm";
    }




}

package hellospring.loginpage.webcontroller;

import hellospring.loginpage.domain.user.User;
import hellospring.loginpage.domain.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

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

    @PostMapping()
    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {


    }


}

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

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String addUserForm(Model model) {
        model.addAttribute(new User());
        return "users/addUserForm";
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/addUserForm";
        }

        userRepository.saveUser(user);
        return "redirect:/";

    }


}

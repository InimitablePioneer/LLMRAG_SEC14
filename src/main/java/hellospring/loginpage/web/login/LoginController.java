package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        User loginUser = loginService.login(form.getUserId(), form.getUserPassword());
        log.info("로그인이 감지되었습니다. loginUser: {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }

        return "redirect:/"; //로그인 성공


    }


}

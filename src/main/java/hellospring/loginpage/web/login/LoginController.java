package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    //@GetMapping("/login")
    public String loginUserForm(Model model) {
        model.addAttribute("loginForm", new LoginUserForm());
        return "login/loginUserForm";
    }

    //@PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginUserForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login/loginUserForm";
        }

        User loginUser = loginService.login(form.getUserId(), form.getUserPassword());
        log.info("로그인이 감지되었습니다. loginUser: {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "올바르지 않은 아이디와 비밀번호 입니다!");
            return "login/loginUserForm";
        }

        return "redirect:/"; //로그인 성공


    }


}

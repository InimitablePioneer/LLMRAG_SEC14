package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.User;
import hellospring.loginpage.web.session.MySessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class LoginControllerV1 {
    private final LoginService loginService;
    private final MySessionManager mySessionManager;

    public LoginControllerV1(LoginService loginService, MySessionManager mySessionManager) {
        this.loginService = loginService;
        this.mySessionManager = mySessionManager;
    }

    //@GetMapping("/login")
    public String loginUserForm(Model model) {
        model.addAttribute("loginForm", new LoginUserForm());
        return "login/loginUserForm";
    }

    //@PostMapping("/login")
    public String loginV1(@Valid @ModelAttribute LoginUserForm form, BindingResult bindingResult
            , HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return "login/loginUserForm";
        }

        User loginUser = loginService.login(form.getUserId(), form.getUserPassword());
        log.info("로그인이 감지되었습니다. loginUser: {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "올바르지 않은 아이디와 비밀번호 입니다!");
        }

        mySessionManager.createMySession(loginUser, response);

        return "redirect:/";
    }

    //@PostMapping("/logout")
    public String logoutUserV1(HttpServletRequest request) {
        mySessionManager.expireSession(request);
        return "redirect:/";
    }
}

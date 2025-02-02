package hellospring.loginpage.web.login;

import hellospring.loginpage.domain.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginControllerV2 { //서블릿의 http세션 사용

    private final LoginService loginService;

    public LoginControllerV2(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String loginUserForm(Model model) {
        model.addAttribute("loginForm", new LoginUserForm());
        return "login/loginUserForm";
    }

    @PostMapping("/login")
    public String loginWithSpringSession(@Valid @ModelAttribute LoginUserForm form,
                          BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginUserForm";
        }

        User loginUser = loginService.login(form.getUserId(), form.getUserPassword());
        log.info("로그인이 감지되었습니다. loginUser: {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "올바르지 않은 아이디와 비밀번호 입니다!");
        }

        HttpSession servletSession = request.getSession();
        servletSession.setAttribute("loginUser", loginUser);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession servletSession) { //스프링이 현재 존재하는 새션을 주입해준다!
        servletSession.invalidate();
        return "redirect:/";
    }

}





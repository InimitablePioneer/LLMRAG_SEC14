package hellospring.loginpage.webcontroller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageControllerWithSpringSession {

    @GetMapping("/")
    public String homePageLoginWithSpringSession(HttpServletRequest request, Model model) {
        HttpSession servletSession = request.getSession(false);
        if (servletSession == null) {
            return "homepage";
        }

        Object user = servletSession.getAttribute("loginUser");

        if (user == null) {
            return "homepage";
        }

        model.addAttribute("user", user);
        return "login/loginHomePage";

    }
}

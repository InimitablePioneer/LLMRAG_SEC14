package hellospring.loginpage.webcontroller;

import hellospring.loginpage.domain.user.User;
import hellospring.loginpage.web.session.MySessionManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomePageController {

    private final MySessionManager mySessionManager;

    public HomePageController(MySessionManager mySessionManager) {
        this.mySessionManager = mySessionManager;
    }


    //@GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/")
    public String homePageLoginV1(HttpServletRequest request, Model model) {

        User user = (User) mySessionManager.getSession(request);

        if (user == null) {
            return "homepage";
        }

        model.addAttribute("user", user);
        return "login/loginHomePage";

    }
}

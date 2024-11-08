package hellospring.loginpage.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    //@GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/")
    public String homeLogin() {

    }
}

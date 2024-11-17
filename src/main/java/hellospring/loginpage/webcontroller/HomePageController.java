package hellospring.loginpage.webcontroller;

import hellospring.loginpage.web.session.MySessionManager;
import org.springframework.stereotype.Controller;


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


}

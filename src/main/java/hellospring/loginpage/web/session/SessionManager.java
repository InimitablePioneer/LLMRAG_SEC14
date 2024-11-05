package hellospring.loginpage.web.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    public static final String SESSION_USER = "user";

    private Map<String, Object> sessionMap = new ConcurrentHashMap<>();


    public void createSession(Object value, HttpServletResponse response) {

    }

    private Cookie findClientCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;
    }





}

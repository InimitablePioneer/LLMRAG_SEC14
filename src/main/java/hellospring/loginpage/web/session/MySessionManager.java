package hellospring.loginpage.web.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MySessionManager {

    public static final String SESSION_USER = "user";

    private Map<String, Object> sessionMap = new ConcurrentHashMap<>();


    public void createSession(Object value, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, value);

        Cookie mySessionCookie = new Cookie(SESSION_USER, sessionId);
        response.addCookie(mySessionCookie);

    }


    public Object getSession(HttpServletRequest request) {
        Cookie myCookie = findClientCookie(request, SESSION_USER);
        if (myCookie == null) {
            return null;
        }
        String value = myCookie.getValue();
        return sessionMap.get(value);
    }


    public void expireSession(HttpServletRequest request) {
        Cookie clientCookie = findClientCookie(request, SESSION_USER);
        if (clientCookie != null) {
            String value = clientCookie.getValue();
            sessionMap.remove(value);
        }
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

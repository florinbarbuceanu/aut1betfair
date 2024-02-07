package courses.ui.utils;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class SeleniumUtils {

    public static void printCookies(Set<Cookie> cookies) {
        System.out.println("Number of cookies found:" + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println("Name:" + cookie.getName());
            System.out.println("-->value:" + cookie.getValue());
            System.out.println("-->domain:" + cookie.getDomain());
            System.out.println("-->expireDate:" + cookie.getExpiry());
            System.out.println("--------------------------end----------------------------");
        }
    }

    public static boolean checkIfCookieExistsByName(String cookieName, Set<Cookie> cookies) {
        for (Cookie cookie : cookies)
            if (cookie.getName().equalsIgnoreCase(cookieName))
                return true;

        return false;
    }

}

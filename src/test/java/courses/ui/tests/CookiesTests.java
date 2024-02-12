package courses.ui.tests;

import courses.ui.utils.BrowsersUtils;
import courses.utils.ConfigUtils;
import courses.utils.ConstantUtils;
import courses.ui.utils.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesTests extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        url = ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE, "hostname", "");
        System.out.println("Url used:" + url);
        driver = BrowsersUtils.getDriver(ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE, "browser", "chrome"));
    }


    @Test
    public void getCookieTest() {
        driver.get(url);
        Set<Cookie> cookies = driver.manage().getCookies();
        SeleniumUtils.printCookies(cookies);
        Assert.assertTrue(SeleniumUtils.checkIfCookieExistsByName("currency", cookies));
        Assert.assertEquals("RON", driver.manage().getCookieNamed("currency").getValue());
    }

    @Test
    public void createCustomCookieTest() {
        driver.get(url);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Numar cookies:" + cookies.size());
        Cookie c = new Cookie("myCookie","this is a testing value");
//        add cookie
        driver.manage().addCookie(c);
        System.out.println("New cookies size:" + driver.manage().getCookies().size());
        Assert.assertTrue(SeleniumUtils.checkIfCookieExistsByName("myCookie", driver.manage().getCookies()));
//        delete added cookie
        driver.manage().deleteCookieNamed("myCookie");
        System.out.println("New cookies size:" + driver.manage().getCookies().size());
        Assert.assertFalse(SeleniumUtils.checkIfCookieExistsByName("myCookie", driver.manage().getCookies()));
//        delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("New cookies size:" + driver.manage().getCookies().size());
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}

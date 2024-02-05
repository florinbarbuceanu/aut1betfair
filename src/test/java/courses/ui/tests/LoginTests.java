package courses.ui.tests;

import courses.ui.pages.MainPage;
import courses.ui.pages.SignInPage;
import courses.ui.utils.BrowsersUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    MainPage mainPage;
    SignInPage signInPage;

    @DataProvider
    public Object[][] loginDP() {
        return new Object[][]{
                {"zebra", "zebrapassword", "chrome"},
                {"dingo", "dingo", "edge"},
                {"camel", "camelpassword", "firefox"},
        };
    }


    @Test(dataProvider = "loginDP")
    public void myFirstSeleniumTest(String username, String password, String browserName) {
        System.out.println("Open next browser:" + browserName);
        driver = BrowsersUtils.getDriver(browserName);
        System.out.println("Open next url:" + url);
        driver.get(url);

        mainPage = new MainPage(driver);
        System.out.println("Go to login page");
        mainPage.openLoginPage();

        System.out.println("Login user");
        signInPage = new SignInPage(driver);
        signInPage.login(username, password);

        Assert.assertTrue(mainPage.getWellcomeMessage().contains(username));
        System.out.println(mainPage.getWellcomeMessage());
    }

    @AfterMethod
    public void closeAtEnd() {
        driver.quit();
    }

    @AfterTest
    public void clean() {
        driver.quit();
    }
}

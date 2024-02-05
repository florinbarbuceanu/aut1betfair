package courses.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    @FindBy(how = How.ID, using = "user")
    WebElement emailInput;

    @FindBy(id = "pass")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        signInButton.click();
    }

    public void enterUsername(String username) {
        emailInput.clear();
        System.out.println("Enter email:" + username);
        emailInput.sendKeys(username);
    }

    public String getEmailValue() {
        return emailInput.getAttribute("value");
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        System.out.println("Enter password:" + password);
        passwordInput.sendKeys(password);
    }

    public String getPasswordValue() {
        return passwordInput.getAttribute("value");
    }
}

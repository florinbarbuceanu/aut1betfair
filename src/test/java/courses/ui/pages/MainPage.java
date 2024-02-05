package courses.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    By signIn = By.xpath("//a[contains(@href,'/signin')]/h2/i");

    @FindBy(xpath = "//h1[contains(text(),'Welcome to web-stubs')]")
    WebElement wellcomeMessage;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signInButton.click();
    }

    public String getWellcomeMessage() {
        wait.until(ExpectedConditions.visibilityOf(wellcomeMessage));
        return wellcomeMessage.getText();
    }

}

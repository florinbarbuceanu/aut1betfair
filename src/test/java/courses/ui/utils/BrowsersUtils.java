package courses.ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowsersUtils {

    public static WebDriver getDriver(String browserName) {
        return BrowsersUtils.getDriver(browserName, "");
    }


    public static WebDriver getDriver(String browserName, String configFile) {
        switch (browserName.toLowerCase()) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                if (!configFile.isEmpty()) {
                    ChromeOptions options = new ChromeOptions();
                    options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "acceptInsecureCerts", "false")));
                    if (ConfigUtils.getGenericValue(configFile, "headlessMode", "false").equalsIgnoreCase("true"))
                        options.addArguments("--headless=new");

                    if (ConfigUtils.getGenericValue(configFile, "downloadDirectoryEnabled", "false").equalsIgnoreCase("true")) {
                        Map<String, Object> preferences = new HashMap<>();
                        preferences.put("download.default_directory", ConstantUtils.DOWNLOAD_DIRECTORY);
                        options.setExperimentalOption("prefs", preferences);
                    }
                    options.addArguments("--start-maximized");
                    return new ChromeDriver(options);
                }
                return new ChromeDriver();
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case ("edge"): {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default: {
                System.out.println("Unsupported browser, will select by default chrome");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
    }
}

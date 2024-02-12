package courses.api.tests;

import courses.utils.ConfigUtils;
import courses.utils.ConstantUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseControllerTests {
    String baseURL, version;

    @BeforeTest
    public void setUp() {
        baseURL = ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE, "apiUrl", "");
        version = ConfigUtils.getGenericValue(ConstantUtils.CONFIG_FILE, "apiVersion", "");
        System.out.println("Use base url with version:" + baseURL + "/" + version);
//        set up rest assured based url
        RestAssured.baseURI = baseURL + "/" + version;
        //ByPass SSL Certificate
        RestAssured.useRelaxedHTTPSValidation();
    }
}

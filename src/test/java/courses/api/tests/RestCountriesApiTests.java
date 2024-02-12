package courses.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestCountriesApiTests extends BaseControllerTests {

    @Test
    public void verifyCountryFilterByNameTest() {

        Response response = given().log().uri().
                when().
                     get("/name/{name}", "rom")
                .then().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    body("name.official[0]", equalTo("Romania")).
                    body("currencies.RON.symbol[0]", equalTo("lei")).
                    extract().response();

        response.getBody().prettyPrint();
    }


    @Test
    public void verifyBorders() {
        List<String> expectedBorders = Arrays.asList("BGR", "HUN", "MDA", "SRB", "UKR");

        List<String> borders = given().log().uri().
                when().
                queryParam("fullText", "true").
                get("/name/{name}", "Romania")
                .then().
                statusCode(200).
                contentType(ContentType.JSON).
//              this is the magic part
        extract().response().jsonPath().getList("borders[0]", String.class);

        System.out.println("Actual borders:" + borders);
        Assert.assertEquals(borders, expectedBorders);
    }
}

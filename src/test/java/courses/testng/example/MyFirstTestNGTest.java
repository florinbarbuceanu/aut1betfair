package courses.testng.example;

import courses.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class MyFirstTestNGTest {
    Calculator c;
    int count;

    @BeforeClass
    public void setUp() {
        c = new Calculator();
        System.out.println("Set Up run before class");
    }

    @BeforeSuite
    public void setupSuite(){
        System.out.println("Run before suite");
    }

    @BeforeGroups(groups = {"Sanity"})
    public void setUpGroups(){
        System.out.println("Set groups");
    }
    @BeforeMethod
    public void setUpBeforeMethod() {
        System.out.println("Run before methode");
    }

    @BeforeTest
    public void setUpBeforeTest() {
        System.out.println("Run before test");
        count = 0;
    }

    @Test(description = "This is first test from class", enabled = false)
    public void test1() {
        System.out.println("Run test1");
    }

    public void test2() {
        System.out.println("Run test 2");
    }

    protected void help() {
        System.out.println("This is a help method");
    }

    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][]{
//              expectedResults,a,b,op,delta
                {6, 2, 3, "+", 0},
                {10, -2, -5, "*", 0},
                {1.4142, 2, 0, "SQRT", 0.0001}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void verifyCalculatorTest(double expectedResults, double a, double b, String op, double delta) {
        System.out.println("Compute calculator assert with delta:" + delta + " for:" + a + " " + op + " " + b + "=" + expectedResults);
        Assert.assertEquals(expectedResults, c.compute(a, b, op), delta);
    }

    @DataProvider
    public Object[][] exceptionCalculatorDataProvider() {
        return new Object[][]{
                {2, 3, "test"},
                {4, 0, "/"}
        };
    }

    @Test(dataProvider = "exceptionCalculatorDataProvider", expectedExceptions = IllegalArgumentException.class)
    public void testException(double a, double b, String op) {
        c.compute(a, b, op);
    }

    @Test(invocationCount = 10, priority = 2, invocationTimeOut = 100L)
    public void testMeInvocation() {
        System.out.println("Run method step:" + count);
        count++;
    }

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void loginTest() {
        System.out.println("Test login");
//        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "loginTest", groups = {"Sanity"})
    public void logOut() {
        System.out.println("LogOut user");
    }


    @Test(dependsOnMethods = "logOut", alwaysRun = true, groups = {"Sanity", "Regression"})
    public void closeTab() {
        System.out.println("Close tab at end");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run after test methode cleanup");
    }

    @AfterGroups(groups = "Sanity")
    public void cleanUpGroups(){
        System.out.println("Clean up groups");
    }

    @AfterClass
    public void afterClassTest() {
        System.out.println("Run after class cleanup");
    }

    @AfterTest
    public void afterTestClean() {
        System.out.println("Run after test");
    }

    @AfterSuite
    public void cleanupSuite(){
        System.out.println("Clean up suite");
    }
}

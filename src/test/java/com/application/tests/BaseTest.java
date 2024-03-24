package com.application.tests;

import com.application.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    public String testSuiteName;
    protected String testName;
    protected String methodName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext context) {
        DriverFactory factory = new DriverFactory(browser);

        this.testSuiteName = context.getSuite().getName();
        this.testName = context.getCurrentXmlTest().getName();
        this.methodName = method.getName();

        driver = factory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        driver.quit();
    }

}

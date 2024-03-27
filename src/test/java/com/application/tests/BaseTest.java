package com.application.tests;

import com.application.core.WebDriverFactorySingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class BaseTest {

    private final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    private WebDriverFactorySingleton factory;
    public String testSuiteName;
    protected String testName;
    protected String methodName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext context) {
        factory = WebDriverFactorySingleton.getInstance();

        this.testSuiteName = context.getSuite().getName();
        this.testName = context.getCurrentXmlTest().getName();
        this.methodName = method.getName();

        driver = factory.createDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        factory.quitDriver();
    }

}

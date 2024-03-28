package com.application.tests;

import com.application.core.WebDriverFactorySingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class BaseTest {

    private final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    private WebDriverFactorySingleton factory;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser) {
        factory = WebDriverFactorySingleton.getInstance();
        driver = factory.createDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        factory.quitDriver();
    }

}

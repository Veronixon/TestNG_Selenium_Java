package com.application.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactorySingleton {
    private static final Logger log = LogManager.getLogger(WebDriverFactorySingleton.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static WebDriverFactorySingleton instance;

    private WebDriverFactorySingleton() {
    }

    public static synchronized WebDriverFactorySingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverFactorySingleton();
        }
        return instance;
    }

    public WebDriver createDriver(String browser) {
        WebDriver driver;
        log.info("Create driver: " + browser);
        switch (browser) {
            case "chrome":
                log.info("Start Chrome driver.");
                driver = getChromeDriver();
                break;
            case "firefox":
                log.info("Start FireFox driver.");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Start Chrome driver.");
                driver = getChromeDriver();
                break;
        }
        driverThreadLocal.set(driver);
        return driver;
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    private WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new ChromeDriver();
    }
}
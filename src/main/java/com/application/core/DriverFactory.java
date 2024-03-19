package com.application.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public DriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver createDriver() {
        // Create driver
        System.out.println("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                System.out.println("Start Chrome driver.");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.out.println("Start FireFox driver.");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Start Chrome driver.");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}

package com.application.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void navigateTo(String baseUrl) {
        driver.get(baseUrl);
    }

    protected abstract boolean isLoaded();
}

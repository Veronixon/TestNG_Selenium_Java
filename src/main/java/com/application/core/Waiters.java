package com.application.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiters {
    public static WebElement waitElementIsVisible(WebElement element, WebDriver driver, int timeout) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement softWaitElementIsVisible(WebElement element, WebDriver driver, int timeout) {
        try {
            return waitElementIsVisible(element, driver, timeout);
        } catch (TimeoutException exception) {
            return null;
        }
    }
}

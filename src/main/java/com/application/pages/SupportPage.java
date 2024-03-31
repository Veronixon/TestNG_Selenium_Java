package com.application.pages;

import com.application.core.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class SupportPage extends AbstractPage {

    @FindBy(xpath = "//section[contains(@class,'-bg-selenium-green')]")
    WebElement helpBanner;

    public SupportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected boolean isLoaded() {
        return Objects.nonNull(Waiters.softWaitElementIsVisible(helpBanner, driver, 20));
    }
}

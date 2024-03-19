package com.application.pages;

import com.application.core.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class MainPage extends AbstractPage{

    @FindBy(id = "announcement-banner")
    WebElement announcmentBanner;
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isLoaded() {
        return Objects.nonNull(Waiters.softWaitElementIsVisible(announcmentBanner, driver, 10));
    }

}

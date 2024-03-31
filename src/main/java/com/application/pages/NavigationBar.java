package com.application.pages;

import com.application.core.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class NavigationBar extends AbstractPage {

    @FindBy(css = ".navbar-brand")
    WebElement brandLogo;

    @FindBy(xpath = "//a[@href='/documentation']")
    WebElement documentationLink;

    @FindBy(xpath = "//a[@href='/support']")
    WebElement supportLink;

    public NavigationBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToSupportPage() {
        supportLink.click();
    }

    public void navigateToDocumentationPage() {
        documentationLink.click();
    }

    @Override
    public boolean isLoaded() {
        return Objects.nonNull(Waiters.softWaitElementIsVisible(brandLogo, driver, 20));
    }
}

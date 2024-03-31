package com.application.pages;

import com.application.core.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class DocumentationPage extends AbstractPage {

    @FindBy(id = "td-section-nav")
    WebElement sideBar;

    public DocumentationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected boolean isLoaded() {
        return Objects.nonNull(Waiters.softWaitElementIsVisible(sideBar, driver, 20));
    }
}

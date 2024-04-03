package com.application.tests;

import com.application.pages.MainPage;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest {
    @Test(testName = "Navigate to Main page")
    @Description("Verify that Main page is opened")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag("Main page"), @Tag("Navigation")})
    @Link("https://www.selenium.dev")
    @TmsLink("https://dev.azure.com/veronixon/Automation/_workitems/edit/2")
    @Epic("Epic - Main page")
    @Feature("Feature - Main page")
    @Story("Implement main page")
    @Owner("Taras")
    @Parameters("MainPageUrl")
    public void verifyMainPageIsOpened(String mainPageUrl) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateTo(mainPageUrl);
        Assert.assertTrue(mainPage.isLoaded(), "Main page is not loaded");
    }


    @Ignore
    @Test(testName = "Navigate to Main page - Fail")
    @Description("Test which always fails")
    @Link(name = "Main Page link", url = "https://www.selenium.dev", type = "custom")
    @TmsLink("https://dev.azure.com/veronixon/Automation/_workitems/edit/2")
    @Issues({@Issue("https://dev.azure.com/veronixon/Automation/_workitems/edit/3"),
            @Issue("https://dev.azure.com/veronixon/Automation/_workitems/edit/4")})
    @Owner("Taras")
    @Epic("Epic - Main page")
    @Feature("Feature - Main page")
    @Story("Implement main page")
    @Parameters("MainPageUrl")
    public void verifyPageIsOpened(String mainPageUrl) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateTo(mainPageUrl);
            Assert.assertTrue(false, "Page is not loaded");
    }
}

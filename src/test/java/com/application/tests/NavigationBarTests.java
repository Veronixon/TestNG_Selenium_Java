package com.application.tests;

import com.application.pages.MainPage;
import com.application.pages.NavigationBar;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigationBarTests extends BaseTest {
    @Test(testName = "Navigate to Support page from Main page navigation bar")
    @Epic("Main page")
    @Feature("Navigation Bar")
    @Story("Navigation Bar")
    @Parameters("MainPageUrl")
    public void navigateToSupportPageFromMainPage(String mainPageUrl) {
        MainPage mainPage = new MainPage(driver);
        NavigationBar navigationBar = new NavigationBar(driver);

        mainPage.navigateTo(mainPageUrl);
        Assert.assertTrue(mainPage.isLoaded(), "Main page is not loaded");
        navigationBar.navigateToSupportPage();
        Assert.assertTrue(false, "Support page is not loaded");
    }

    @Test(testName = "Navigate to Documentation page from Main page navigation bar")
    @Epic("Main page")
    @Feature("Navigation Bar")
    @Story("Navigation Bar")
    @Parameters("MainPageUrl")
    public void navigateToDocumentationPageFromMainPage(String mainPageUrl) {
        MainPage mainPage = new MainPage(driver);
        NavigationBar navigationBar = new NavigationBar(driver);

        mainPage.navigateTo(mainPageUrl);
        Assert.assertTrue(mainPage.isLoaded(), "Main page is not loaded");
        navigationBar.navigateToDocumentationPage();
        Assert.assertTrue(false, "Documentation page is not loaded");
    }
}
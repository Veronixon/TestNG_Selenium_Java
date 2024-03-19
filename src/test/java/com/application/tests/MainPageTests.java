package com.application.tests;
import com.application.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest {

    @Parameters("MainPageUrl")
    @Test()
    public void verifyMainPageIsOpened(String mainPageUrl){
        MainPage mainPage = new MainPage(driver);

        mainPage.navigateTo(mainPageUrl);
        Assert.assertTrue(mainPage.isLoaded(), "Main page is not loaded");
    }

}

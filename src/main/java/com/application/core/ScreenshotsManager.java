package com.application.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.application.core.helpers.DateHelper.getTodayDateInProperFormat;

public class ScreenshotsManager {
    private static Logger log =  LogManager.getLogger(ScreenshotsManager.class);

    /**
     * This function will take screenshot
     *
     * @param driver
     * @throws Exception
     */

    public static void takeScreenShot(WebDriver driver, String testSuiteName, String testName, String methodName) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir")
                + File.separator + "screenshots"
                + File.separator + getTodayDateInProperFormat("dd/MM/yyyy")
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + methodName
                + " " + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        }catch (IOException exception){
            log.info(exception.getMessage());
        }
    }
}

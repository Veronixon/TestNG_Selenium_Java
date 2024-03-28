package com.application.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotsManager {
    private static final Logger log = LogManager.getLogger(ScreenshotsManager.class);

    /**
     * This function will take screenshot
     *
     * @param testName String name of the test
     * @throws Exception
     */

    public static void takeScreenShot(String testName) {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverFactorySingleton.getInstance().getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("test-output"
                + File.separator + "screenshots"
                + File.separator + testName + "_"
                + System.currentTimeMillis()
                + ".png");
        try {
            log.info("Attach screenshot to failed test.");
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException exception) {
            log.info("Failed to attach screenshot to test.");
        }
    }
}

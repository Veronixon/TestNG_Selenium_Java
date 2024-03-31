package com.application.core;

import io.qameta.allure.Allure;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ScreenshotsManager {
    private static final Logger log = LogManager.getLogger(ScreenshotsManager.class);

    /**
     * This function will take screenshot and save it as a file to the temporary folder
     *
     * @param testName String name of the test
     * @throws Exception
     */

    public static void takeScreenshotAndSaveAsFile(String testName) {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverFactorySingleton.getInstance().getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("target"
                + File.separator + "screenshots"
                + File.separator + getScreenshotName(testName));
        try {
            log.info("Attach screenshot to failed test.");
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException exception) {
            log.info("Failed to attach screenshot to test.");
        }
    }

    /**
     * This function will take screenshot and attach it to Allure report
     *
     * @param testName String name of the test
     * @throws Exception
     */
    public static void takeScreenshotForAllureReport(String testName) {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverFactorySingleton.getInstance().getDriver());
        byte[] screenshot = scrShot.getScreenshotAs(OutputType.BYTES);
        log.info("Attach screenshot to failed test.");
        Allure.addAttachment(getScreenshotName(testName), new ByteArrayInputStream(screenshot));
    }

    private static String getScreenshotName(String testName) {
        return testName + "_" + System.currentTimeMillis() + ".png";
    }
}

package com.application.core.listeners;


import com.application.core.ScreenshotsManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.LogManager;

public class TestNGListener implements ITestListener {

    private Logger log;

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotsManager.takeScreenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        this.log = LogManager.getLogger(result.getMethod().getMethodName());
        log.info(result.getMethod().getMethodName() + " Log on skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        this.log = LogManager.getLogger(result.getMethod().getMethodName());
        log.info(result.getMethod().getMethodName() + " Log on fail with success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.log = LogManager.getLogger(result.getMethod().getMethodName());
        log.info(result.getMethod().getMethodName() + " Log on fail with timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        this.log = LogManager.getLogger(context.getName());
        log.info(context.getName() + " Log on start");
    }

    @Override
    public void onFinish(ITestContext context) {
        this.log = LogManager.getLogger(context.getName());
        log.info(context.getName() + " Log on finish");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " Log on test start");
    }
}

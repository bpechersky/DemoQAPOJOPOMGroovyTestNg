package com.demoqa.listeners

import com.codeborne.selenide.Screenshots
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener)

    @Override
    void onTestFailure(ITestResult result) {
        logger.error("❌ Test Failed: ${result.name}")

        def screenshot = Screenshots.takeScreenShotAsFile()
        if (screenshot != null && screenshot.exists()) {
            logger.info("📸 Screenshot saved: ${screenshot.absolutePath}")
        } else {
            logger.warn("⚠️ Screenshot could not be taken.")
        }
    }

    @Override
    void onTestStart(ITestResult result) {}
    @Override
    void onTestSuccess(ITestResult result) {}
    @Override
    void onTestSkipped(ITestResult result) {}
    @Override
    void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    void onStart(ITestContext context) {}
    @Override
    void onFinish(ITestContext context) {}
}

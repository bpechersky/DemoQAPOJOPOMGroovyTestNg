package com.demoqa

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import io.github.bonigarcia.wdm.WebDriverManager

class BaseTest {
    WebDriver driver

    @BeforeMethod
    void setup() {
        WebDriverManager.chromedriver().setup()
        ChromeOptions options = new ChromeOptions()
        options.addArguments("--start-maximized")
        driver = new ChromeDriver(options)
    }

    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit()
        }
    }
}

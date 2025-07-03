package com.demoqa

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.BeforeClass

class BaseTest {

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup()

        Configuration.browser = "chrome"
        Configuration.browserSize = "1920x1080"
        Configuration.headless = true


        ChromeOptions options = new ChromeOptions()
        options.addArguments(
                "--headless=new",              // proper headless mode
                "--window-size=1920,1080",
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage"
        )

        Configuration.browserCapabilities = options
    }
}


package com.demoqa

import com.codeborne.selenide.Configuration
import org.testng.annotations.BeforeMethod

class BaseTest {

    @BeforeMethod
    void setUp() {
        Configuration.browser = "chrome"
        Configuration.headless = true // or true if you want
        Configuration.timeout = 10000
        Configuration.browserSize = "1920x1080" // ← updated from removed startMaximized

        Configuration.browserCapabilities.setCapability("goog:chromeOptions", [
                args: [
                        "--disable-gpu",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-extensions",
                        "--remote-allow-origins=*"
                        // "--headless=new" // only if headless mode
                ]
        ])
    }
}

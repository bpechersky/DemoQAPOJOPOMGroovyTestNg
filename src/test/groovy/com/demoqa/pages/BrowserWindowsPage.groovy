package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.WebDriverRunner.*
import static com.codeborne.selenide.Condition.*

class BrowserWindowsPage {

    SelenideElement newTabButton = $("#tabButton")
    SelenideElement newWindowButton = $("#windowButton")

    void openPage() {
        open("https://demoqa.com/browser-windows")
    }

    void clickNewTab() {
        newTabButton.shouldBe(visible).click()
    }

    void clickNewWindow() {
        newWindowButton.shouldBe(visible).click()
    }

    String switchToNewWindowAndGetHeading() {
        def originalWindow = getWebDriver().getWindowHandle()
        def allWindows = getWebDriver().getWindowHandles()

        // Wait until new window appears
        waitUntilWindowCountIsGreaterThan(1)

        for (def windowHandle : allWindows) {
            if (windowHandle != originalWindow) {
                switchTo().window(windowHandle)
                break
            }
        }

        def heading = $("#sampleHeading").shouldBe(visible).text

        // Close the new window and switch back
        closeWindow()
        switchTo().window(originalWindow)

        return heading
    }

    private void waitUntilWindowCountIsGreaterThan(int count) {
        for (int i = 0; i < 10; i++) {
            if (getWebDriver().getWindowHandles().size() > count) break
            sleep(500)
        }
    }

    private void closeWindow() {
        getWebDriver().close()
    }
}

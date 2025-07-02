package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class ProgressBarPage {

    SelenideElement startStopButton = $("#startStopButton")
    SelenideElement progressBar = $("#progressBar")
    SelenideElement resetButton = $("#resetButton")

    void openPage() {
        open("https://demoqa.com/progress-bar")
        executeJavaScript("document.querySelector('footer')?.remove()")
        executeJavaScript("document.querySelector('#fixedban')?.remove()")
    }


    void startProgressBar() {
        startStopButton.shouldBe(enabled).click()
    }

    void waitForProgressToReach(int targetPercent, int timeoutMs = 15000) {
        long startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime < timeoutMs) {
            String percentStr = progressBar.getAttribute("aria-valuenow")
            if (percentStr?.isInteger() && percentStr.toInteger() >= targetPercent) {
                break
            }
            sleep(100)
        }
        startStopButton.click() // stop it once target is hit
    }

    int getCurrentProgressPercent() {
        return progressBar.getAttribute("aria-valuenow")?.toInteger()
    }

    void resetProgress() {
        resetButton.shouldBe(visible, enabled).click()
    }
}

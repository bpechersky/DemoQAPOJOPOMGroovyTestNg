package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement
import java.time.Duration


class ProgressBarPage {

    def openPage() {
        open("https://demoqa.com/progress-bar")
    }

    SelenideElement getStartStopButton() {
        return $("#startStopButton")
    }

    SelenideElement getProgressBar() {
        return $("#progressBar")
    }

    def clickStartStop() {
        getStartStopButton().click()
    }

    def waitForProgress(int targetPercentage, int timeoutSeconds = 30) {
        def expectedText = "${targetPercentage}%"
        def progressBar = getProgressBar()
        progressBar.shouldBe(visible, Duration.ofSeconds(5)) // short wait to become visible
        progressBar.shouldHave(text(expectedText), Duration.ofSeconds(timeoutSeconds))
    }



    def getProgressValue() {
        return getProgressBar().text.replace("%", "").trim().toInteger()
    }
}

package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import java.time.Duration

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selenide.*

class DynamicPropertiesPage {

    private final String URL = "https://demoqa.com/dynamic-properties"

    SelenideElement visibleAfterBtn = $("#visibleAfter")
    SelenideElement enableAfterBtn = $("#enableAfter")
    SelenideElement colorChangeBtn = $("#colorChange")

    void openPage() {
        open(URL)
    }

    boolean isButtonVisibleAfterDelay() {
        visibleAfterBtn.shouldBe(visible, Duration.ofSeconds(10))
        return visibleAfterBtn.isDisplayed()
    }

    boolean isButtonEnabledAfterDelay() {
        enableAfterBtn.shouldBe(enabled, Duration.ofSeconds(10))
        return enableAfterBtn.isEnabled()
    }

    boolean isColorChanged() {
        // Wait and check for class change or style attribute
        colorChangeBtn.shouldHave(cssClass("text-danger"), Duration.ofSeconds(10))
        return colorChangeBtn.getAttribute("class").contains("text-danger")
    }
}

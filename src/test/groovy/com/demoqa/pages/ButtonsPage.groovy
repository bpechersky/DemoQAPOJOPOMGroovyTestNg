package com.demoqa.pages

import com.codeborne.selenide.SelenideElement
import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selenide.*
import java.time.Duration

class ButtonsPage {

    private final String URL = "https://demoqa.com/buttons"

    SelenideElement doubleClickBtn = $("#doubleClickBtn")
    SelenideElement rightClickBtn = $("#rightClickBtn")
    SelenideElement dynamicClickBtn = $x("//button[text()='Click Me']")


    SelenideElement doubleClickMessage = $("#doubleClickMessage")
    SelenideElement rightClickMessage = $("#rightClickMessage")
    SelenideElement dynamicClickMessage = $("#dynamicClickMessage")

    void openPage() {
        open(URL)
    }

    void performDoubleClick() {
        doubleClickBtn.shouldBe(visible).doubleClick()
    }

    void performRightClick() {
        rightClickBtn.shouldBe(visible).contextClick()
    }

    void clickDynamicButton() {
        dynamicClickBtn.shouldBe(visible).click()
    }

    String getDoubleClickText() {
        return doubleClickMessage.shouldBe(visible, Duration.ofSeconds(5)).text()
    }

    String getRightClickText() {
        return rightClickMessage.shouldBe(visible, Duration.ofSeconds(5)).text()
    }

    String getDynamicClickText() {
        return dynamicClickMessage.shouldBe(visible, Duration.ofSeconds(5)).text()
    }
}

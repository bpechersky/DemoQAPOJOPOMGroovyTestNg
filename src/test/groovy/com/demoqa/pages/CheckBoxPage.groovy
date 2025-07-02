package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class CheckBoxPage {

    SelenideElement expandAllButton = $("#tree-node > ol > li > span > button")
    SelenideElement homeCheckbox = $("#tree-node-home").parent().$(".rct-checkbox")
    SelenideElement resultText = $("#result")

    void openPage() {
        open("https://demoqa.com/checkbox")
    }

    void expandAll() {
        expandAllButton.shouldBe(visible).click()
    }

    void checkHomeCheckbox() {
        homeCheckbox.shouldBe(visible).click()
    }

    void shouldShowSelectedHome() {
        resultText.shouldBe(visible).shouldHave(text("home"))
    }
}

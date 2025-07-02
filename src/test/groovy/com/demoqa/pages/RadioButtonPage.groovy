package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class RadioButtonPage {

    SelenideElement yesRadio = $("label[for='yesRadio']")
    SelenideElement impressiveRadio = $("label[for='impressiveRadio']")
    SelenideElement result = $(".text-success")

    void openPage() {
        open("https://demoqa.com/radio-button")
    }

    void selectYes() {
        yesRadio.shouldBe(visible).click()
    }

    void selectImpressive() {
        impressiveRadio.shouldBe(visible).click()
    }

    String getSelectedResult() {
        return result.shouldBe(visible).text
    }
}

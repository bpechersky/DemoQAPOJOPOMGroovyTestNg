package com.demoqa.pages

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.Keys

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class SelectMenuPage {

    void openPage() {
        open("https://demoqa.com/select-menu")
    }

    // Elements
    SelenideElement oldStyleSelect = $("#oldSelectMenu")
    SelenideElement selectValueInput = $("#withOptGroup input")
    SelenideElement selectOneInput = $("#selectOne input")
    SelenideElement multiSelectDropDown = $("#selectMenuContainer div[class*='css-1hwfws3']")
    SelenideElement standardMultiSelect = $("#cars")

    // Actions
    void selectOldStyleOption(String value) {
        oldStyleSelect.selectOption(value)
    }

    void selectValue(String visibleText) {
        selectValueInput.setValue(visibleText).sendKeys(Keys.ENTER)
    }

    void selectOne(String visibleText) {
        selectOneInput.setValue(visibleText).sendKeys(Keys.ENTER)
    }

    void selectMultipleStandardOptions(List<String> values) {
        values.each { val ->
            standardMultiSelect.selectOption(val)
        }
    }
}

package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class ToolTipsPage {

    private final String URL = "https://demoqa.com/tool-tips"

    SelenideElement hoverMeButton = $("#toolTipButton")
    SelenideElement inputField = $("#toolTipTextField")
    SelenideElement contraryLink = $x("//a[text()='Contrary']")
    SelenideElement versionLink = $x("//a[text()='1.10.32']")

    void openPage() {
        open(URL)
    }

    void hoverOverButton() {
        hoverMeButton.hover()
    }

    void hoverOverInput() {
        inputField.hover()
    }

    void hoverOverContrary() {
        contraryLink.hover()
    }

    void hoverOverVersionLink() {
        versionLink.hover()
    }

    String getToolTipText() {
        $(".tooltip-inner").should(appear).text()
    }
}

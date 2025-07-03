package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class AccordianPage {

    def openPage() {
        open("https://demoqa.com/accordian")
    }

    SelenideElement getSectionHeader(String sectionId) {
        return $("#${sectionId}")
    }

    SelenideElement getSectionBody(String bodyId) {
        return $("#${bodyId}")
    }

    def expandSection(String headerId) {
        getSectionHeader(headerId).scrollIntoView(true).click()
    }

    def isSectionExpanded(String bodyId) {
        return getSectionBody(bodyId).isDisplayed()
    }

    def getSectionText(String bodyId) {
        return getSectionBody(bodyId).text
    }
}

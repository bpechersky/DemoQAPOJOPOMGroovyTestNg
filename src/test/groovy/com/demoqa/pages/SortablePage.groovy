package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import static com.codeborne.selenide.Selenide.actions

class SortablePage {

    def openPage() {
        open("https://demoqa.com/sortable")
    }

    ElementsCollection getListItems() {
        return $$("#demo-tabpane-list .list-group-item")
    }

    ElementsCollection getGridItems() {
        return $$("#demo-tabpane-grid .list-group-item")
    }

    def switchToGridTab() {
        $("#demo-tab-grid").click()
    }

    def dragAndDrop(SelenideElement source, SelenideElement target) {
        actions().dragAndDrop(source, target).perform()
    }

    def getListOrder() {
        return getListItems().texts()
    }

    def getGridOrder() {
        return getGridItems().texts()
    }
}

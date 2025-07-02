package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class AlertsPage {

    def openPage() {
        open("https://demoqa.com/alerts")
    }

    def clickSimpleAlertButton() {
        $("#alertButton").click()
    }

    def clickDelayedAlertButton() {
        $("#timerAlertButton").click()
    }

    def clickConfirmAlertButton() {
        $("#confirmButton").click()
    }

    def clickPromptAlertButton() {
        $("#promtButton").click()
    }

    def getConfirmResult() {
        return $("#confirmResult").text()
    }

    def getPromptResult() {
        return $("#promptResult").text()
    }
}

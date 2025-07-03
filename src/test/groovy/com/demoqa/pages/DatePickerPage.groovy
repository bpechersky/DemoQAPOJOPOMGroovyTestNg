package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class DatePickerPage {

    def openPage() {
        open("https://demoqa.com/date-picker")
    }

    SelenideElement getDateInput() {
        return $("#datePickerMonthYearInput")
    }

    SelenideElement getDateTimeInput() {
        return $("#dateAndTimePickerInput")
    }

    def setDate(String date) {
        executeJavaScript("document.getElementById('datePickerMonthYearInput').value = arguments[0]", date)
    }

    def setDateTime(String dateTime) {
        executeJavaScript("document.getElementById('dateAndTimePickerInput').value = arguments[0]", dateTime)
    }


    def getDateValue() {
        return getDateInput().value
    }

    def getDateTimeValue() {
        return getDateTimeInput().value
    }
}

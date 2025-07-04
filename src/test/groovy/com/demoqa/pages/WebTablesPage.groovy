package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selectors.*
import static com.codeborne.selenide.Selenide.*

class WebTablesPage {

    private final String URL = "https://demoqa.com/webtables"

    SelenideElement addButton = $("#addNewRecordButton")
    SelenideElement firstNameInput = $("#firstName")
    SelenideElement lastNameInput = $("#lastName")
    SelenideElement emailInput = $("#userEmail")
    SelenideElement ageInput = $("#age")
    SelenideElement salaryInput = $("#salary")
    SelenideElement departmentInput = $("#department")
    SelenideElement submitButton = $("#submit")

    void openPage() {
        open(URL)
    }

    void clickAdd() {
        addButton.click()
    }

    void fillForm(String firstName, String lastName, String email, String age, String salary, String department) {
        firstNameInput.setValue(firstName)
        lastNameInput.setValue(lastName)
        emailInput.setValue(email)
        ageInput.setValue(age)
        salaryInput.setValue(salary)
        departmentInput.setValue(department)
    }

    void submitForm() {
        submitButton.click()
    }

    boolean isRecordPresent(String email) {
        return $$(".rt-tr-group").findBy(text(email)).exists()
    }

    void deleteRecordByEmail(String email) {
        def row = $$(".rt-tr-group").findBy(text(email))
        row.$(byTitle("Delete")).click()
    }
}

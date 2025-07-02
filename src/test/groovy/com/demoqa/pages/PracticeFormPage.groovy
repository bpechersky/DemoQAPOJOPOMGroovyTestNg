package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class PracticeFormPage {

    SelenideElement firstName = $("#firstName")
    SelenideElement lastName = $("#lastName")
    SelenideElement email = $("#userEmail")
    SelenideElement genderMale = $x("//label[text()='Male']")
    SelenideElement genderFemale = $x("//label[text()='Female']")
    SelenideElement mobileNumber = $("#userNumber")
    SelenideElement submitButton = $("#submit")
    SelenideElement confirmationModal = $("#example-modal-sizes-title-lg")

    void openPage() {
        open("https://demoqa.com/automation-practice-form")
        executeJavaScript("document.querySelector('footer').remove()")  // Remove footer to avoid blocking
        executeJavaScript("document.querySelector('#fixedban').remove()") // Remove ad banner
    }

    void fillForm(String fName, String lName, String emailAddr, String gender, String phone) {
        firstName.setValue(fName)
        lastName.setValue(lName)
        email.setValue(emailAddr)
        if (gender == "Male") {
            genderMale.click()
        } else if (gender == "Female") {
            genderFemale.click()
        }
        mobileNumber.setValue(phone)
    }

    void submitForm() {
        submitButton.scrollIntoView(true).click()
    }

    String getConfirmationTitle() {
        return confirmationModal.shouldBe(visible).text
    }
}

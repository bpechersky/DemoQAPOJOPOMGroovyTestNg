package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Selectors.*
import static com.codeborne.selenide.Condition.*

class TextBoxPage {

    void open() {
        open("https://demoqa.com/text-box")
    }

    void fillForm(String name, String email, String currentAddress, String permanentAddress) {
        $("#userName").setValue(name)
        $("#userEmail").setValue(email)
        $("#currentAddress").setValue(currentAddress)
        $("#permanentAddress").setValue(permanentAddress)
        $("#submit").scrollIntoView(true).click()
    }

    String getOutputName() {
        return $("#name").getText().replace("Name:", "").trim()
    }
}

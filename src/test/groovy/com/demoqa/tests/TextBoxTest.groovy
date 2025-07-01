package com.demoqa.tests

import com.codeborne.selenide.Configuration
import com.demoqa.pages.TextBoxPage
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import com.demoqa.models.User

class TextBoxTest {

    @BeforeClass
    static void setup() {
        Configuration.browser = "chrome"
        Configuration.browserSize = "1920x1080"
        Configuration.headless = true
    }

    @Test
    void testFillTextBoxForm() {
        def user = new User("Boris", "boris@example.com", "123 Main St", "456 Other St")

        def page = new TextBoxPage()
        page.open()
        page.fillForm(user.name, user.email, user.currentAddress, user.permanentAddress)

        assert page.getOutputName() == "Boris"
    }
}

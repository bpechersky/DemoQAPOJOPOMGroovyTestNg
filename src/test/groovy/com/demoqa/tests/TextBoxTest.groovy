package com.demoqa.tests

import com.codeborne.selenide.Configuration
import com.demoqa.pages.TextBoxPage
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class TextBoxTest {

    @BeforeClass
    static void setup() {
        Configuration.browser = "chrome"
        Configuration.browserSize = "1920x1080"
        Configuration.headless = true
    }

    @Test
    void testFillTextBoxForm() {
        def page = new TextBoxPage()
        page.open()
        page.fillForm("Boris", "boris@example.com", "123 Main St", "456 Other St")
        assert page.getOutputName() == "Boris"
    }
}

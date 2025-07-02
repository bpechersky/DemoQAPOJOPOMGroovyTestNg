package com.demoqa.tests

import com.codeborne.selenide.Configuration
import com.demoqa.BaseTest
import com.demoqa.pages.TextBoxPage
import io.github.bonigarcia.wdm.WebDriverManager
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import com.demoqa.models.User

class TextBoxTest extends  BaseTest{



    @Test
    void testFillTextBoxForm() {
        def user = new User("Boris", "boris@example.com", "123 Main St", "456 Other St")

        def page = new TextBoxPage()
        page.open()
        page.fillForm(user.name, user.email, user.currentAddress, user.permanentAddress)

        assert page.getOutputName() == "Boris"
    }
}

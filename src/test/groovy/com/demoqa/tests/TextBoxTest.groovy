package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.TextBoxPage
import org.testng.annotations.Test

class TextBoxTest extends BaseTest {

    @Test
    void testFillTextBoxForm() {
        TextBoxPage page = new TextBoxPage(driver)
        page.open()
        page.fillForm("Boris", "boris@example.com", "123 Main St", "456 Other St")
        assert page.getOutputName() == "Boris"
    }
}

package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.PracticeFormPage
import org.testng.annotations.Test

class PracticeFormTest extends BaseTest {

    @Test
    void testSubmitPracticeForm() {
        def page = new PracticeFormPage()
        page.openPage()

        page.fillForm("Boris", "Tester", "boris@example.com", "Male", "1234567890")
        page.submitForm()

        assert page.getConfirmationTitle() == "Thanks for submitting the form"
    }
}

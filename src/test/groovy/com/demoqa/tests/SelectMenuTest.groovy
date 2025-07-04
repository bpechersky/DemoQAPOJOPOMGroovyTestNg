package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.SelectMenuPage
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.*
import static org.testng.Assert.*
import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Selenide.*

class SelectMenuTest extends BaseTest {

    @Test
    void testOldStyleDropdown() {
        def page = new SelectMenuPage()
        page.openPage()

        page.selectOldStyleOption("Purple")

        def selected = $("#oldSelectMenu").getSelectedOption().text
        assert selected == "Purple"
    }





    @Test
    void testSelectValueDropdown() {
        def page = new SelectMenuPage()
        page.openPage()

        page.selectValue("Group 1, option 1")

        // ✅ Correct: stable class for selected value
        $(".css-1uccc91-singleValue").shouldHave(text("Group 1, option 1"))
    }


    @Test
    void testSelectOneDropdown() {
        def page = new SelectMenuPage()
        page.openPage()

        page.selectOne("Dr.")
        $(".css-1uccc91-singleValue").shouldHave(text("Dr."))
    }

    @Test
    void testStandardMultiSelect() {
        def page = new SelectMenuPage()
        page.openPage()

        page.selectMultipleStandardOptions(["Volvo", "Opel"])
        def selectedOptions = $("#cars").getSelectedOptions()*.text
        assert selectedOptions.containsAll(["Volvo", "Opel"])
    }
}

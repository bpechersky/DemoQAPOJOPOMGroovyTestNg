package com.demoqa.tests

import com.codeborne.selenide.SelenideElement
import com.demoqa.BaseTest
import com.demoqa.pages.CheckBoxPage
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class CheckBoxTest extends BaseTest {

    @Test
    void testCheckHomeCheckbox() {
        def checkBoxPage = new CheckBoxPage()
        checkBoxPage.openPage()
        checkBoxPage.expandAll()
        checkBoxPage.checkHomeCheckbox()
        checkBoxPage.shouldShowSelectedHome()
    }
}

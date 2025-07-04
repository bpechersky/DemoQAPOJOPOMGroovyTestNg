package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.ButtonsPage
import com.codeborne.selenide.WebDriverRunner
import org.testng.annotations.Test

import static org.testng.Assert.*

class ButtonsTest extends BaseTest {

    @Test
    void testButtonClicks() {
        def page = new ButtonsPage()
        page.openPage()

        page.performDoubleClick()
        assert page.getDoubleClickText().toLowerCase().contains("double click")

        page.performRightClick()
        assert page.getRightClickText().toLowerCase().contains("right click")

        page.clickDynamicButton()
        println("Page source:\n" + WebDriverRunner.source())
        assert page.getDynamicClickText().toLowerCase().contains("you have done a dynamic click")
    }
}

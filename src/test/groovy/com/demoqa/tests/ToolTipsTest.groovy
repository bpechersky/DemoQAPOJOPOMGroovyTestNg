package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.ToolTipsPage
import org.testng.annotations.Test

import static org.testng.Assert.*

class ToolTipsTest extends BaseTest {

    @Test
    void testAllToolTips() {
        def page = new ToolTipsPage()
        page.openPage()

        // Hover over the button
        page.hoverOverButton()
        sleep(1000)  // Give time for tooltip to appear
        assert page.getToolTipText().toLowerCase().contains("you hovered over the button")

        // Hover over the input field
        page.hoverOverInput()
        sleep(1000)  // Allow previous tooltip to disappear and new to appear
        assert page.getToolTipText().toLowerCase().contains("you hovered over the text field")

        // Hover over "Contrary" link
        page.hoverOverContrary()
        sleep(1000)
        assert page.getToolTipText().toLowerCase().contains("you hovered over the contrary")

        // Hover over "1.10.32" link
        page.hoverOverVersionLink()
        sleep(1000)
        assert page.getToolTipText().toLowerCase().contains("you hovered over the 1.10.32")
    }

}


package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.BrowserWindowsPage
import org.testng.annotations.Test

class BrowserWindowsTest extends BaseTest {

    @Test
    void testNewTabOpensAndShowsHeading() {
        def page = new BrowserWindowsPage()
        page.openPage()
        page.clickNewTab()

        def headingText = page.switchToNewWindowAndGetHeading()

        assert headingText == "This is a sample page"
    }

    @Test
    void testNewWindowOpensAndShowsHeading() {
        def page = new BrowserWindowsPage()
        page.openPage()
        page.clickNewWindow()

        def headingText = page.switchToNewWindowAndGetHeading()

        assert headingText == "This is a sample page"
    }
}

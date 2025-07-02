package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.MenuPage
import org.testng.annotations.Test

class MenuTest extends BaseTest {

    @Test
    void testMenuHoverDisplaysSubmenu() {
        def page = new MenuPage()
        page.open()
        page.hoverMainItem("Main Item 2")
        page.isSubItemVisible("SUB SUB LIST »")
        page.hoverSubItem("Main Item 2", "SUB SUB LIST »")
        page.isSubItemVisible("Sub Sub Item 1")
    }
}

package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.TabsPage
import org.testng.annotations.Test
import static org.testng.Assert.*
import static com.codeborne.selenide.Condition.cssClass


class TabsTest extends BaseTest {
    @Test
    void testTabsContent() {
        TabsPage page = new TabsPage()
        page.openPage()

        page.clickWhatTab()
        assert page.getContentText().toLowerCase().contains("lorem ipsum is simply dummy text")


        page.clickOriginTab()
        assert page.getContentText().toLowerCase().contains("classical latin literature")

        page.clickUseTab()
        assert page.getContentText().toLowerCase().contains("readable content of a page")

        if (!page.tabMore.has(cssClass("disabled"))) {
            page.clickMoreTab()
            assert page.getContentText().toLowerCase().contains("it is a long established fact")
        } else {
            println("Skipping assertion for 'More' tab because it is disabled")
        }
    }

}

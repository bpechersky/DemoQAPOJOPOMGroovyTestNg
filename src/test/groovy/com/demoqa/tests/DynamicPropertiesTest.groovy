package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.DynamicPropertiesPage
import org.testng.annotations.Test

import static org.testng.Assert.assertTrue

class DynamicPropertiesTest extends BaseTest {

    @Test
    void testDynamicProperties() {
        def page = new DynamicPropertiesPage()
        page.openPage()

        assertTrue(page.isButtonVisibleAfterDelay(), "'Visible After' button did not appear")
        assertTrue(page.isButtonEnabledAfterDelay(), "'Enable After' button was not enabled")
        assertTrue(page.isColorChanged(), "'Color Change' button did not change color")
    }
}

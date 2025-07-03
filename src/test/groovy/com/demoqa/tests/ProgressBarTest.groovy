package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.ProgressBarPage
import org.testng.annotations.Test

import static org.testng.Assert.*

class ProgressBarTest extends BaseTest {

    @Test
    void testProgressBarReachesTarget() {
        def page = new ProgressBarPage()
        page.openPage()

        page.clickStartStop()
        page.waitForProgress(100, 40) // Adjust timeout if needed

        assertEquals(page.getProgressValue(), 100)
    }
}

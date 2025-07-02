package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.ProgressBarPage
import org.testng.annotations.Test

class ProgressBarTest extends BaseTest {

    @Test
    void testProgressBarReachesTarget() {
        def page = new ProgressBarPage()
        page.openPage()
        page.startProgressBar()
        page.waitForProgressToReach(75)

        def percent = page.getCurrentProgressPercent()
        assert percent >= 75 && percent <= 100
    }

    @Test
    void testProgressBarReset() {
        def page = new ProgressBarPage()
        page.openPage()
        page.startProgressBar()
        page.waitForProgressToReach(50)
        page.resetProgress()

        assert page.getCurrentProgressPercent() == 0
    }
}

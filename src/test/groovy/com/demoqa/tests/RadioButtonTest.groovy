package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.RadioButtonPage
import org.testng.annotations.Test

class RadioButtonTest extends BaseTest {

    @Test
    void testSelectYesOption() {
        def page = new RadioButtonPage()
        page.openPage()
        page.selectYes()
        assert page.getSelectedResult() == "Yes"
    }

    @Test
    void testSelectImpressiveOption() {
        def page = new RadioButtonPage()
        page.openPage()
        page.selectImpressive()
        assert page.getSelectedResult() == "Impressive"
    }
}


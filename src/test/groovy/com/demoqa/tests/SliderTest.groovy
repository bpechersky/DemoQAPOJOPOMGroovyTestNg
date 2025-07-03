package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.SliderPage
import org.testng.annotations.Test

import static org.testng.Assert.*


class SliderTest extends BaseTest {

    @Test
    void testSliderValueChange() {
        SliderPage sliderPage = new SliderPage()
        sliderPage.openPage()
        sliderPage.setSliderValue(75)
        int value = sliderPage.getSliderValue()
        println "Slider value after setting: $value"
        assert value == 75

    }
}

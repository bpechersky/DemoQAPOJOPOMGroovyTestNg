package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class SliderPage {

    // FIXED selector
    SelenideElement slider = $("input[type='range']")

    void openPage() {
        open("https://demoqa.com/slider")
    }

    void setSliderValue(int value) {
        slider.shouldBe(visible)
        executeJavaScript("arguments[0].value = arguments[1]", slider, value)
        executeJavaScript("arguments[0].dispatchEvent(new Event('change'))", slider)
    }

    int getSliderValue() {
        return Integer.parseInt(slider.getValue())
    }
}

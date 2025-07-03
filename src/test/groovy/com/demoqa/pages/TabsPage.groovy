package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import com.codeborne.selenide.SelenideElement

class TabsPage {

    SelenideElement tabWhat = $("#demo-tab-what")
    SelenideElement tabOrigin = $("#demo-tab-origin")
    SelenideElement tabUse = $("#demo-tab-use")
    SelenideElement tabMore = $("#demo-tab-more")

    SelenideElement content = $(".tab-content")

    void openPage() {
        open("https://demoqa.com/tabs")
    }

    void clickWhatTab() {
        tabWhat.shouldBe(visible).click()
    }

    void clickOriginTab() {
        tabOrigin.shouldBe(visible).click()
    }

    void clickUseTab() {
        tabUse.shouldBe(visible).click()
    }

    void clickMoreTab() {
        if (!tabMore.has(cssClass("disabled"))) {
            tabMore.shouldBe(visible).click()
        } else {
            println("Skipping 'More' tab: it is disabled")
        }
    }

    String getContentText() {
        return content.shouldBe(visible).getText()
    }
}

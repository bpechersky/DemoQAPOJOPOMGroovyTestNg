package com.demoqa.pages

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class MenuPage {

    def open() {
        open("https://demoqa.com/menu")
    }

    def hoverMainItem(String itemLabel) {
        $$("ul#nav > li > a").findBy(text(itemLabel)).hover()
    }

    def hoverSubItem(String parentLabel, String subLabel) {
        def parent = $$("ul#nav > li").find { it.text.contains(parentLabel) }
        parent?.hover()
        parent?.$$("ul > li > a")?.findBy(text(subLabel))?.hover()
    }

    def isSubItemVisible(String label) {
        $$("ul#nav li ul li a").findBy(text(label)).shouldBe(visible)
    }
}

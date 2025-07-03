package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Selectors.byText

class BrokenLinksPage {

    void openPage() {
        open("https://demoqa.com/broken")
    }

    SelenideElement getValidLink() {
        return $(byText("Click Here for Valid Link"))
    }

    SelenideElement getBrokenLink() {
        return $(byText("Click Here for Broken Link"))
    }

    String getCurrentUrl() {
        return webdriver().driver().getWebDriver().getCurrentUrl()
    }

    int getFinalResponseStatus(String url) {
        def connection = (HttpURLConnection) new URL(url).openConnection()
        connection.instanceFollowRedirects = true
        connection.setRequestMethod("GET")
        connection.connect()
        int responseCode = connection.responseCode

        // Follow redirect manually if needed (for safety)
        if (responseCode in [301, 302]) {
            def newUrl = connection.getHeaderField("Location")
            connection.disconnect()
            return getFinalResponseStatus(newUrl)
        }

        return responseCode
    }

}

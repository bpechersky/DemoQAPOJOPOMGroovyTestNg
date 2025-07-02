package com.demoqa.tests

import com.codeborne.selenide.Selenide
import com.demoqa.BaseTest
import com.demoqa.pages.AlertsPage
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.*
import static org.testng.Assert.*

class AlertsTest extends BaseTest {

    @Test
    void testSimpleAlert() {
        def page = new AlertsPage()
        page.openPage()
        page.clickSimpleAlertButton()
        switchTo().alert().accept()
    }

    @Test
    void testDelayedAlert() {
        def page = new AlertsPage()
        page.openPage()
        page.clickDelayedAlertButton()
        Selenide.sleep(6000) // Wait for alert to appear
        switchTo().alert().accept()
    }

    @Test
    void testConfirmAlertAccept() {
        def page = new AlertsPage()
        page.openPage()
        page.clickConfirmAlertButton()
        switchTo().alert().accept()
        assert page.getConfirmResult() == "You selected Ok"
    }

    @Test
    void testConfirmAlertDismiss() {
        def page = new AlertsPage()
        page.openPage()
        page.clickConfirmAlertButton()
        switchTo().alert().dismiss()
        assert page.getConfirmResult() == "You selected Cancel"
    }

    @Test
    void testPromptAlert() {
        def page = new AlertsPage()
        page.openPage()
        page.clickPromptAlertButton()
        def alert = switchTo().alert()
        alert.sendKeys("Boris")
        alert.accept()
        assert page.getPromptResult() == "You entered Boris"
    }
}

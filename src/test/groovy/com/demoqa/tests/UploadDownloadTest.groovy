package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.UploadDownloadPage
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.Selenide
import org.testng.annotations.Test

import java.io.File

import static com.codeborne.selenide.Selenide.$
import static org.testng.Assert.*

class UploadDownloadTest extends BaseTest {

    @Test
    void testDownloadButton() {
        def page = new UploadDownloadPage()
        page.openPage()

        // ✅ Confirm page has loaded
        def pageTitle = WebDriverRunner.getWebDriver().getTitle()
        assert pageTitle.contains("DEMOQA") : "Unexpected page title: $pageTitle"

        // Optional: screenshot for debug
        com.codeborne.selenide.Selenide.screenshot("before_download")

        // ✅ Confirm and click download button
        assert $("#downloadButton").exists() : "Download button not found on the page"
        page.clickDownloadButton()
    }


    @Test
    void testUploadFile() {
        def page = new UploadDownloadPage()
        page.openPage()

        def fileToUpload = new File("src/test/resources/testfile.txt")
        page.uploadFile(fileToUpload)

        def uploadedPath = page.getUploadedFilePath()
        assertTrue(uploadedPath.contains("testfile.txt"), "Uploaded file path is incorrect")
    }
}

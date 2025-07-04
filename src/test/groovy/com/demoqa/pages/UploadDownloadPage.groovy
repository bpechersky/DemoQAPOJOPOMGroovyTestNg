package com.demoqa.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class UploadDownloadPage {

    SelenideElement downloadButton = $("#downloadButton")
    SelenideElement uploadInput = $("#uploadFile")
    SelenideElement uploadedFilePath = $("#uploadedFilePath")

    void openPage() {
        open("https://demoqa.com/upload-download")
    }

    void clickDownloadButton() {
        downloadButton.shouldBe(visible).click()
    }

    void uploadFile(File file) {
        uploadInput.uploadFile(file)
    }

    String getUploadedFilePath() {
        return uploadedFilePath.shouldBe(visible).text
    }
}

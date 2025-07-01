package com.demoqa.pages

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class TextBoxPage {
    WebDriver driver

    TextBoxPage(WebDriver driver) {
        this.driver = driver
    }

    void open() {
        driver.get("https://demoqa.com/text-box")
    }

    void fillForm(String name, String email, String currentAddress, String permanentAddress) {
        driver.findElement(By.id("userName")).sendKeys(name)
        driver.findElement(By.id("userEmail")).sendKeys(email)
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress)
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress)

        def submitButton = driver.findElement(By.id("submit"))
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton)
    }

    String getOutputName() {
        return driver.findElement(By.id("name")).getText().replace("Name:", "").trim()
    }
}

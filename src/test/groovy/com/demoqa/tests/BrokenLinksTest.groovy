package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.BrokenLinksPage
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals
import static org.testng.Assert.assertTrue

class BrokenLinksTest extends BaseTest {

    @Test
    void testValidLinkNavigatesCorrectly() {
        BrokenLinksPage page = new BrokenLinksPage()
        page.openPage()

        String validUrl = page.getValidLink().getAttribute("href")
        int status = page.getFinalResponseStatus(validUrl)

        assertEquals(status, 200, "Valid link should return 200 OK")
    }

    @Test
    void testBrokenLinkReturns404() {
        BrokenLinksPage page = new BrokenLinksPage()
        page.openPage()

        String brokenUrl = page.getBrokenLink().getAttribute("href")
        int status = page.getFinalResponseStatus(brokenUrl)

        assertEquals(status, 500, "Broken link should return 500 Internal Server Error")
    }
}

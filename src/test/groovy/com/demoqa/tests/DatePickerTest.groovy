package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.DatePickerPage
import org.testng.annotations.Test

import static org.testng.Assert.*

class DatePickerTest extends BaseTest {

    @Test
    void testSelectDate() {
        def page = new DatePickerPage()
        page.openPage()

        def testDate = "07/05/2025"
        page.setDate(testDate)
        assertEquals(page.getDateValue(), testDate)
    }

    @Test
    void testSelectDateTime() {
        def page = new DatePickerPage()
        page.openPage()

        def testDateTime = "July 5, 2025 2:30 PM"
        page.setDateTime(testDateTime)
        assertEquals(page.getDateTimeValue(), testDateTime)
    }

}

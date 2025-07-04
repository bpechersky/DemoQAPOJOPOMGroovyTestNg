package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.WebTablesPage
import org.testng.annotations.Test

import static org.testng.Assert.*

class WebTablesTest extends BaseTest {

    @Test
    void testAddAndDeleteRecord() {
        def page = new WebTablesPage()
        page.openPage()

        page.clickAdd()
        page.fillForm("Boris", "Pechersky", "boris@example.com", "35", "50000", "QA")
        page.submitForm()

        assert page.isRecordPresent("boris@example.com") : "Record was not added"

        page.deleteRecordByEmail("boris@example.com")

        assert !page.isRecordPresent("boris@example.com") : "Record was not deleted"
    }
}

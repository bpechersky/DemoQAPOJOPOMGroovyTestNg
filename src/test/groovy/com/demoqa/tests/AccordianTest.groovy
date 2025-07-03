package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.AccordianPage
import org.testng.annotations.Test

import static org.testng.Assert.*

class AccordianTest extends BaseTest {

    @Test
    void testSection1Expansion() {
        def page = new AccordianPage()
        page.openPage()

        page.expandSection("section1Heading")
        assertTrue(page.isSectionExpanded("section1Content"))
        assert page.getSectionText("section1Content").contains("Lorem Ipsum")
    }

    @Test
    void testSection2Expansion() {
        def page = new AccordianPage()
        page.openPage()

        page.expandSection("section2Heading")
        assertTrue(page.isSectionExpanded("section2Content"))
        assert page.getSectionText("section2Content").contains("Lorem Ipsum")
    }

    @Test
    void testSection3Expansion() {
        def page = new AccordianPage()
        page.openPage()

        page.expandSection("section3Heading")
        assertTrue(page.isSectionExpanded("section3Content"))
        assert page.getSectionText("section3Content").contains("Lorem Ipsum")
    }
}

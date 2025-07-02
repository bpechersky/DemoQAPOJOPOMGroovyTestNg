package com.demoqa.tests

import com.demoqa.BaseTest
import com.demoqa.pages.SortablePage
import org.testng.annotations.Test

import static org.testng.Assert.*

class SortableTest extends BaseTest {

    @Test
    void testListSortable() {
        def page = new SortablePage()
        page.openPage()

        def items = page.getListItems()
        def originalOrder = page.getListOrder()

        page.dragAndDrop(items.get(0), items.get(3)) // Move Item 1 below Item 4

        def newOrder = page.getListOrder()
        assertNotEquals(newOrder, originalOrder, "List order should change after drag-and-drop")
    }

    @Test
    void testGridSortable() {
        def page = new SortablePage()
        page.openPage()
        page.switchToGridTab()

        def items = page.getGridItems()
        def originalOrder = page.getGridOrder()

        page.dragAndDrop(items.get(0), items.get(5)) // Move One below Six

        def newOrder = page.getGridOrder()
        assertNotEquals(newOrder, originalOrder, "Grid order should change after drag-and-drop")
    }
}

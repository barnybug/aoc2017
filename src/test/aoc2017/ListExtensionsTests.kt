package aoc2017

import org.junit.Test
import org.junit.Assert.assertEquals

class ListExtensionsTests {
    @Test
    fun `combination`() {
        val expected = listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3))
        assertEquals(expected, listOf(1, 2, 3).combination(2).toList())
    }
}
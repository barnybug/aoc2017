package aoc2017

import org.junit.Test
import org.junit.Assert.assertEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ListExtensionsTests {
    @Test
    fun `combination`() {
        val expected = listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3))
        assertEquals(expected, listOf(1, 2, 3).combination(2).toList())
    }

    @Test
    fun `cycle`() {
        assertEquals(listOf(1, 2, 3), listOf(1, 2, 3).cycle(0))
        assertEquals(listOf(3, 1, 2), listOf(1, 2, 3).cycle(1))
        assertEquals(listOf(2, 3, 1), listOf(1, 2, 3).cycle(2))
        assertEquals(listOf(1, 2, 3), listOf(1, 2, 3).cycle(3))
        assertEquals(listOf(3, 1, 2), listOf(1, 2, 3).cycle(4))
        assertEquals(listOf(2, 3, 1), listOf(1, 2, 3).cycle(-1))
    }

    @Test
    fun `window`() {
        assertEquals(listOf(listOf(1, 2), listOf(2, 3)), listOf(1, 2, 3).window(2))
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)), listOf(1, 2, 3).window(1))
        assertEquals(listOf(listOf(1, 2, 3)), listOf(1, 2, 3).window(3))
        assertEquals(emptyList<List<Int>>(), listOf(1, 2, 3).window(4))
    }

    private fun assertPermutation(list: List<List<Int>>, k: Int, set: Set<Int>) {
        assertEquals(list.distinct(), list, "all elements are unique")
        for (element in list) {
            // correct number of elements
            // draws from the set
            // does not use replacement
            assertEquals(k, set.intersect(element).size)
        }
    }

    @Test
    fun `permute 2`() {
        val bag = listOf(1, 2)
        val actual = bag.permute(2).toList()
        assertEquals(2, actual.size)
        assertPermutation(actual, 2, bag.toSet())
    }

    @Test
    fun `permute 3`() {
        val bag = listOf(1, 2, 3)
        val actual = bag.permute(3).toList()
        assertEquals(6, actual.size)
        assertPermutation(actual, 3, bag.toSet())
    }

    @Test
    fun `permute 2 of 3`() {
        val bag = listOf(1, 2, 3)
        val actual = bag.permute(2).toList()
        assertEquals(6, actual.size)
        assertPermutation(actual, 2, bag.toSet())
    }

    @Test
    fun `permute 2 of 4`() {
        val bag = listOf(1, 2, 3, 4)
        val actual = bag.permute(2).toList()
        assertEquals(12, actual.size)
        assertPermutation(actual, 2, bag.toSet())
    }
}
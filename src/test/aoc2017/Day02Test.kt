package aoc2017

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.coroutines.experimental.buildIterator

internal class Day02Test {
    @Test
    fun `part 1 examples`() {
        assertEquals(18, Day02("5\t1\t9\t5\n" +
                "7\t5\t3\n" +
                "2\t4\t6\t8").answer1())
    }

    @Test
    fun `part 1`() {
        assertEquals(46402, Day02(Inputs.readText(2)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        assertEquals(4, Day02("5\t9\t2\t8").answer2())
        assertEquals(3, Day02("9\t4\t7\t3").answer2())
        assertEquals(2, Day02("3\t8\t6\t5").answer2())
        assertEquals(9, Day02("5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5").answer2())
    }

    @Test
    fun `part 2`() {
        assertEquals(265, Day02(Inputs.readText(2)).answer2())
    }
}
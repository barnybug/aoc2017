package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day04Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day04("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day04(Inputs.readText(4)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day04("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day04(Inputs.readText(4)).answer2())
    }
}
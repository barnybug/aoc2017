package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day18Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day18("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day18(Inputs.readText(18)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day18("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day18(Inputs.readText(18)).answer2())
    }
}
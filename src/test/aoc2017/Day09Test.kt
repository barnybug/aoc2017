package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day09Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day09("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day09(Inputs.readText(9)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day09("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day09(Inputs.readText(9)).answer2())
    }
}
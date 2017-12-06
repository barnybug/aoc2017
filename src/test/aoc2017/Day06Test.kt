package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day06Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(5, Day06("0  2  7  0").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(3156, Day06(Inputs.readText(6)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(4, Day06("0  2  7  0").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(1610, Day06(Inputs.readText(6)).answer2())
    }
}
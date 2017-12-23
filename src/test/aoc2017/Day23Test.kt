package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day23Test {
    @Test
    fun `part 1`() {
        Assert.assertEquals(9409, Day23(Inputs.readText(23)).answer1())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(913, Day23(Inputs.readText(23)).answer2())
    }
}
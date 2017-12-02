package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day05Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day05("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day05(Inputs.readText(5)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day05("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day05(Inputs.readText(5)).answer2())
    }
}
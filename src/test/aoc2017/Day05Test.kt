package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day05Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(5, Day05("0\n3\n0\n1\n-3").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(358131, Day05(Inputs.readText(5)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(10, Day05("0\n3\n0\n1\n-3").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(25558839, Day05(Inputs.readText(5)).answer2())
    }
}
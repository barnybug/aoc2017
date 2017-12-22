package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day21Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(12, Day21("../.# => ##./#../...\n" +
                ".#./..#/### => #..#/..../..../#..#").answer1(2))
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(133, Day21(Inputs.readText(21)).answer1(5))
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day21(Inputs.readText(21)).answer1(18))
    }
}
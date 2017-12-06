package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day04Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(1, Day04("aa bb cc dd ee").answer1())
        Assert.assertEquals(0, Day04("aa bb cc dd aa").answer1())
        Assert.assertEquals(1, Day04("aa bb cc dd aaa").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(325, Day04(Inputs.readText(4)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(1, Day04("abcde fghij").answer2())
        Assert.assertEquals(0, Day04("abcde xyz ecdab").answer2())
        Assert.assertEquals(1, Day04("a ab abc abd abf abj").answer2())
        Assert.assertEquals(1, Day04("iiii oiii ooii oooi oooo").answer2())
        Assert.assertEquals(0, Day04("oiii ioii iioi iiio").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(119, Day04(Inputs.readText(4)).answer2())
    }
}
package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day07Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day07("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day07(Inputs.readText(7)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day07("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day07(Inputs.readText(7)).answer2())
    }
}
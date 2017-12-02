package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day19Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day19("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day19(Inputs.readText(19)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day19("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day19(Inputs.readText(19)).answer2())
    }
}
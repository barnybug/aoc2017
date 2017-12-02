package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day08Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day08("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day08(Inputs.readText(8)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day08("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day08(Inputs.readText(8)).answer2())
    }
}
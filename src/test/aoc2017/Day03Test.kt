package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day03Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day03("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day03(Inputs.readText(3)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day03("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day03(Inputs.readText(3)).answer2())
    }
}
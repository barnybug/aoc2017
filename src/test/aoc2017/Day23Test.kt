package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day23Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day23("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day23(Inputs.readText(23)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day23("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day23(Inputs.readText(23)).answer2())
    }
}
package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day17Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day17("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day17(Inputs.readText(17)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day17("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day17(Inputs.readText(17)).answer2())
    }
}
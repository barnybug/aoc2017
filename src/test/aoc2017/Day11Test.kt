package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day11Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(3, Day11("ne,ne,ne").answer1())
        Assert.assertEquals(0, Day11("ne,ne,sw,sw").answer1())
        Assert.assertEquals(2, Day11("ne,ne,s,s").answer1())
        Assert.assertEquals(3, Day11("se,sw,se,sw,sw").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(794, Day11(Inputs.readText(11)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(3, Day11("ne,ne,ne").answer2())
        Assert.assertEquals(2, Day11("ne,ne,sw,sw").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(1524, Day11(Inputs.readText(11)).answer2())
    }
}
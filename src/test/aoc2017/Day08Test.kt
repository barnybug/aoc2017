package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day08Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(1, Day08("b inc 5 if a > 1\na inc 1 if b < 5\nc dec -10 if a >= 1\nc inc -20 if c == 10").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(5075, Day08(Inputs.readText(8)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(10, Day08("b inc 5 if a > 1\na inc 1 if b < 5\nc dec -10 if a >= 1\nc inc -20 if c == 10").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(7310, Day08(Inputs.readText(8)).answer2())
    }
}
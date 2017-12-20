package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day13Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(24, Day13("0: 3\n1: 2\n4: 4\n6: 4").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(1840, Day13(Inputs.readText(13)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(10, Day13("0: 3\n1: 2\n4: 4\n6: 4").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(3850260, Day13(Inputs.readText(13)).answer2())
    }
}
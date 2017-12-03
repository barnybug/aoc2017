package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day03Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day03(1).answer1())
        Assert.assertEquals(3, Day03(12).answer1())
        Assert.assertEquals(2, Day03(23).answer1())
        Assert.assertEquals(31, Day03(1024).answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(552, Day03(325489).answer1())
    }

    @Test
    fun `part 2 examples`() {
        // some random picks from the example
        Assert.assertEquals(10, Day03(6).answer2())
        Assert.assertEquals(59, Day03(58).answer2())
        Assert.assertEquals(147, Day03(143).answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(330785, Day03(325489).answer2())
    }
}
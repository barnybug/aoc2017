package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day10Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(12, Day10("3,4,1,5", 5).answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(4480, Day10(Inputs.readText(10)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10("").answer2())
        Assert.assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10("AoC 2017").answer2())
        Assert.assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10("1,2,3").answer2())
        Assert.assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10("1,2,4").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals("c500ffe015c83b60fad2e4b7d59dabc4", Day10(Inputs.readText(10)).answer2())
    }
}
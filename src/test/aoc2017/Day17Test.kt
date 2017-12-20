package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day17Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(638, Day17(3).answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(204, Day17(380).answer1())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(28954211, Day17(380).answer2())
    }
}
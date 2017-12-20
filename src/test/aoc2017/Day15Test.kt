package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day15Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(1, Day15(65, 8921).answer(5))
        Assert.assertEquals(588, Day15(65, 8921).answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(577, Day15(618, 814).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(309, Day15(65, 8921).answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(316, Day15(618, 814).answer2())
    }
}
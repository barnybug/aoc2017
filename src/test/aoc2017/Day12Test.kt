package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day12Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(6, Day12("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(113, Day12(Inputs.readText(12)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(2, Day12("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(202, Day12(Inputs.readText(12)).answer2())
    }
}
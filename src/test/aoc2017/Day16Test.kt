package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day16Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals("baedc", Day16("s1,x3/4,pe/b").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals("nlciboghjmfdapek", Day16(Inputs.readText(16)).answer1())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals("nlciboghmkedpfja", Day16(Inputs.readText(16)).answer2())
    }
}
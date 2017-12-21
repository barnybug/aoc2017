package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day19Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals("ABCDEF", Day19("     |          \n" +
                "     |  +--+    \n" +
                "     A  |  C    \n" +
                " F---|----E|--+ \n" +
                "     |  |  |  D \n" +
                "     +B-+  +--+ \n").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals("SXWAIBUZY", Day19(Inputs.readText(19)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(38, Day19("     |          \n" +
                "     |  +--+    \n" +
                "     A  |  C    \n" +
                " F---|----E|--+ \n" +
                "     |  |  |  D \n" +
                "     +B-+  +--+ \n").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(16676, Day19(Inputs.readText(19)).answer2())
    }
}
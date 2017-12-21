package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day18Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(4, Day18("set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(4601, Day18(Inputs.readText(18)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(3, Day18("snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(6858, Day18(Inputs.readText(18)).answer2())
    }
}
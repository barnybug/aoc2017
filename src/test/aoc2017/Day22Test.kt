package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day22Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(5, Day22("..#\n" +
                "#..\n" +
                "...").answer1(7))
        Assert.assertEquals(41, Day22("..#\n" +
                "#..\n" +
                "...").answer1(70))
        Assert.assertEquals(5587, Day22("..#\n" +
                "#..\n" +
                "...").answer1(10000))
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(5348, Day22(Inputs.readText(22)).answer1(10000))
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(26, Day22("..#\n" +
                "#..\n" +
                "...").answer2(100))
        Assert.assertEquals(2511944, Day22("..#\n" +
                "#..\n" +
                "...").answer2(10000000))
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(2512225, Day22(Inputs.readText(22)).answer2(10000000))
    }
}
package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day24Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(31, Day24("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(2006, Day24(Inputs.readText(24)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(19, Day24("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(1994, Day24(Inputs.readText(24)).answer2())
    }
}
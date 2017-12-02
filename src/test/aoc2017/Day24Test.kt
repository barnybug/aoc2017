package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day24Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day24("").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(0, Day24(Inputs.readText(24)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day24("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day24(Inputs.readText(24)).answer2())
    }
}
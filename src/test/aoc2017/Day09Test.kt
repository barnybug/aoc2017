package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day09Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(1, Day09("{}").answer1())
        Assert.assertEquals(6, Day09("{{{}}}").answer1())
        Assert.assertEquals(5, Day09("{{},{}}").answer1())
        Assert.assertEquals(16, Day09("{{{},{},{{}}}}").answer1())
        Assert.assertEquals(1, Day09("{<a>,<a>,<a>,<a>}").answer1())
        Assert.assertEquals(9, Day09("{{<ab>},{<ab>},{<ab>},{<ab>}}").answer1())
        Assert.assertEquals(9, Day09("{{<!!>},{<!!>},{<!!>},{<!!>}}").answer1())
        Assert.assertEquals(3, Day09("{{<a!>},{<a!>},{<a!>},{<ab>}}").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(14204, Day09(Inputs.readText(9)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day09("<>").answer2())
        Assert.assertEquals(17, Day09("<random characters>").answer2())
        Assert.assertEquals(3, Day09("<<<<>").answer2())
        Assert.assertEquals(2, Day09("<{!>}>").answer2())
        Assert.assertEquals(0, Day09("<!!>").answer2())
        Assert.assertEquals(0, Day09("<!!!>>").answer2())
        Assert.assertEquals(10, Day09("<{o\"i!a,<{i<a>").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(6622, Day09(Inputs.readText(9)).answer2())
    }
}
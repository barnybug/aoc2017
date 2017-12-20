package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day14Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(8108, Day14("flqrgnkx").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(8140, Day14("jxqlasbh").answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(1242, Day14("flqrgnkx").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(1182, Day14("jxqlasbh").answer2())
    }
}
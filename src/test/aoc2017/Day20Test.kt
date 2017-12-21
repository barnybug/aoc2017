package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day20Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(0, Day20("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>\n" +
                "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>").answer1())
        Assert.assertEquals(1, Day20("p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>\n" +
                "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(91, Day20(Inputs.readText(20)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(1, Day20("p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>\n" +
                "p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>\n" +
                "p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>\n" +
                "p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(567, Day20(Inputs.readText(20)).answer2())
    }
}
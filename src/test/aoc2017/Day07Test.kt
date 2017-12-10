package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day07Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals("tknk", Day07("pbga (66)\nxhth (57)\nebii (61)\nhavc (66)\nktlj (57)\nfwft (72) -> ktlj, cntj, xhth\nqoyq (66)\npadx (45) -> pbga, havc, qoyq\ntknk (41) -> ugml, padx, fwft\njptl (61)\nugml (68) -> gyxo, ebii, jptl\ngyxo (61)\ncntj (57)").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals("eqgvf", Day07(Inputs.readText(7)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(60, Day07("pbga (66)\nxhth (57)\nebii (61)\nhavc (66)\nktlj (57)\nfwft (72) -> ktlj, cntj, xhth\nqoyq (66)\npadx (45) -> pbga, havc, qoyq\ntknk (41) -> ugml, padx, fwft\njptl (61)\nugml (68) -> gyxo, ebii, jptl\ngyxo (61)\ncntj (57)").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(757, Day07(Inputs.readText(7)).answer2())
    }
}
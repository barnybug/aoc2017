package aoc2017

import org.junit.Assert
import org.junit.Test

internal class Day25Test {
    @Test
    fun `part 1 examples`() {
        Assert.assertEquals(3, Day25("Begin in state A.\n" +
                "Perform a diagnostic checksum after 6 steps.\n" +
                "\n" +
                "In state A:\n" +
                "  If the current value is 0:\n" +
                "    - Write the value 1.\n" +
                "    - Move one slot to the right.\n" +
                "    - Continue with state B.\n" +
                "  If the current value is 1:\n" +
                "    - Write the value 0.\n" +
                "    - Move one slot to the left.\n" +
                "    - Continue with state B.\n" +
                "\n" +
                "In state B:\n" +
                "  If the current value is 0:\n" +
                "    - Write the value 1.\n" +
                "    - Move one slot to the left.\n" +
                "    - Continue with state A.\n" +
                "  If the current value is 1:\n" +
                "    - Write the value 1.\n" +
                "    - Move one slot to the right.\n" +
                "    - Continue with state A.").answer1())
    }

    @Test
    fun `part 1`() {
        Assert.assertEquals(2526, Day25(Inputs.readText(25)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        Assert.assertEquals(0, Day25("").answer2())
    }

    @Test
    fun `part 2`() {
        Assert.assertEquals(0, Day25(Inputs.readText(25)).answer2())
    }
}
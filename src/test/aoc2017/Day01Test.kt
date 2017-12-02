package aoc2017

import org.junit.Test
import org.junit.Assert.assertEquals

class Day01Test {
    @Test
    fun `part 1 examples`() {
        assertEquals(3, Day01("1122").answer1())
        assertEquals(4, Day01("1111").answer1())
        assertEquals(0, Day01("1234").answer1())
        assertEquals(9, Day01("91212129").answer1())
    }

    @Test
    fun `part 1`() {
        assertEquals(1029, Day01(Inputs.readText(1)).answer1())
    }

    @Test
    fun `part 2 examples`() {
        assertEquals(6, Day01("1212").answer2())
        assertEquals(0, Day01("1221").answer2())
        assertEquals(4, Day01("123425").answer2())
        assertEquals(12, Day01("123123").answer2())
        assertEquals(4, Day01("12131415").answer2())
    }

    @Test
    fun `part 2`() {
        assertEquals(1220, Day01(Inputs.readText(1)).answer2())
    }
}
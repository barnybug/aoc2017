package aoc2017

class Day01(private val input: String) {
    private fun puzzle(divide: Int): Int {
        val n = input.map { it - '0' }
        return n.zip(n.takeLast(divide) + n.take(n.size-divide))
                .sumBy { (a, b) -> if (a == b) a else 0 }
    }

    fun answer1() = puzzle(1)
    fun answer2() = puzzle(input.length/2)
}
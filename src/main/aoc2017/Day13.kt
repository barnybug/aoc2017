package aoc2017

class Day13(private val input: String) {
    val rules = input.lines().associate { line ->
        val (left, right) = line.split(": ")
        left.toInt() to right.toInt()
    }
    val size = rules.keys.max() ?: 0

    fun severity(delay: Int) =
        (0..size).sumBy { i ->
            val depth = rules[i] ?: 0
            if (depth > 0) {
                val scanner = (i+delay) % (depth * 2 - 2)
                if (scanner == 0)
                    (i+delay) * depth
                else
                    0
            } else {
                0
            }
        }

    fun answer1() = severity(0)

    fun answer2() =
        (0..Int.MAX_VALUE).first { severity(it) == 0 }
}
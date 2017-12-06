package aoc2017

class Day04(private val input: String) {
    fun answer1() = input.lines().map { it.words() }.count {
        it.distinct().size == it.size
    }

    fun answer2() = input.lines().map { it.words() }.count {
        it.map { it.toList().sorted().join() }.distinct().size == it.size
    }
}
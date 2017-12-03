package aoc2017

class Day02(private val input: String) {
    fun answer1() = input
            .lines()
            .map { line ->
                val v = line.split("\t").map { it.toInt() }
                v.max()!! - v.min()!!
            }
            .sum()
    fun answer2() = input
            .lines()
            .map { line ->
                val v = line.split("\t").map { it.toInt() }
                val answer = v.sortedDescending().combination(2).find {
                    it[0] % it[1] == 0
                }!!
                answer[0] / answer[1]

            }.sum()
}
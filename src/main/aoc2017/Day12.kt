package aoc2017

class Day12(private val input: String) {
    val rules = input.lines().associate { line ->
        val (left, right) = line.split(" <-> ")
        left.toInt() to right.split(", ").map { it.toInt() }
    }

    fun reachable(i: Int): Set<Int> {
        val full = mutableSetOf(i)
        var last = setOf(i)
        while(last.isNotEmpty()) {
            val next = last.flatMap { rules[it] ?: listOf() }
            last = next.toSet() - full
            full.addAll(last)
        }
        return full
    }

    fun answer1() = reachable(0).size

    fun answer2(): Int {
        var groups = 0
        var used = rules.keys
        while(used.isNotEmpty()) {
            val i = used.first()
            used -= reachable(i)
            groups++
        }
        return groups
    }
}
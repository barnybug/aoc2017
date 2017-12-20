package aoc2017

class Day15(private val seedA: Int, private val seedB: Int) {
    fun answer(steps: Int): Int {
        val a = generateSequence(seedA) { v -> (v.toLong() * 16807 % 2147483647).toInt() }
        val b = generateSequence(seedB) { v -> (v.toLong() * 48271 % 2147483647).toInt() }
        return a.zip(b).drop(1).take(steps).count { (a, b) -> a and 0xffff == b and 0xffff }
    }

    fun answer1() = answer(40000000)
    fun answer2(): Int {
        val a = generateSequence(seedA) { v -> (v.toLong() * 16807 % 2147483647).toInt() }.filter { it % 4 == 0 }
        val b = generateSequence(seedB) { v -> (v.toLong() * 48271 % 2147483647).toInt() }.filter { it % 8 == 0 }
        return a.zip(b).drop(1).take(5000000).count { (a, b) -> a and 0xffff == b and 0xffff }
    }
}
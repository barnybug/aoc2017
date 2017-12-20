package aoc2017

class Day16(private val input: String) {
    val initial = ('a'..'p').joinToString("")

    fun once(s: String) = input.split(",").fold(s) { v, p ->
        when(p[0]) {
        's' -> {
            val n = p.substring(1).toInt()
            v.substring(v.length - n) + v.substring(0, v.length - n)
        }
        'x' -> {
            val ns = p.substring(1).split("/").map { it.toInt() }
            v.toMutableList().apply { swap(ns[0], ns[1]) }.join()
        }
        'p' -> {
            val a = v.indexOf(p[1])
            val b = v.indexOf(p[3])
            v.toMutableList().apply { swap(a, b) }.join()
        }
        else -> v
        }
    }

    fun answer1() = once(initial)

    fun answer2(): String {
        var s = once(initial)
        val seq = generateSequence(initial) { once(it) }.drop(1)
        val repeat = seq.indexOfFirst { it == initial } + 1
        val remain = (1000000000 % repeat)
        return seq.take(remain).last()
    }
}
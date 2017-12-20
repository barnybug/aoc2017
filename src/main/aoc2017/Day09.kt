package aoc2017

class Day09(private val input: String) {
    fun answer1(): Int {
        var level = 0
        var score = 0
        var garbage = false
        val it = input.iterator()
        for (ch in it) {
            when {
                ch == '!' -> it.next()
                ch == '>' -> garbage = false
                garbage -> {}
                ch == '<' -> garbage = true
                ch == '{' -> level++
                ch == '}' -> {
                    score += level
                    level--
                }
            }
        }
        return score
    }

    fun answer2(): Int {
        val it = input.iterator()
        var garbage = false
        var value = 0
        for (ch in it) {
            when {
                ch == '!' -> it.next()
                ch == '>' -> garbage = false
                garbage -> value++
                ch == '<' -> garbage = true
            }
        }
        return value
    }
}
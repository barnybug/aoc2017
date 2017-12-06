package aoc2017

class Day05(private val input: String) {
    fun answer1(): Int {
        val state = input.lines().map { it.toInt() }.toMutableList()
        var pos = 0
        var steps = 0
        while(pos >=0 && pos < state.size) {
            state[pos] += 1
            pos += state[pos]-1
            steps += 1
        }
        return steps
    }

    fun answer2(): Int {
        val state = input.lines().map { it.toInt() }.toMutableList()
        var pos = 0
        var steps = 0
        while(pos >=0 && pos < state.size) {
            if (state[pos] >= 3) {
                state[pos] -= 1
                pos += state[pos] + 1
            } else {
                state[pos] += 1
                pos += state[pos]-1
            }
            steps += 1
        }
        return steps
    }
}
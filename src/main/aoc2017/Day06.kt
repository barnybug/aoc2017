package aoc2017

class Day06(private val input: String) {
    private fun run(): Pair<Int, Int> {
        var steps = 0
        val state = input.words().map { it.toInt() }.toMutableList()
        val seen = mutableMapOf<List<Int>, Int>()
        while(!seen.contains(state)) {
            seen[state] = steps
            val highest = state.indexOfFirst { it == state.max() }
            val r = state[highest]
            state[highest] = 0
            for(i in highest+1 .. (highest+r)) {
                state[i % state.size]++
            }
            steps++
        }
        return steps to steps - seen[state]!!
    }

    fun answer1() = run().first

    fun answer2() = run().second
}
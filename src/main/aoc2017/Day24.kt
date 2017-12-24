package aoc2017

class Day24(private val input: String) {
    private val parts = parseInput()

    private fun parseInput(): MutableMap<Int, List<Int>> {
        // parts are unique
        val parts = mutableMapOf<Int, List<Int>>()
        input.lines().forEach { line ->
            val (left, right) = line.split("/").map { it.toInt() }
            parts[left] = parts.getOrDefault(left, listOf()).plus(right)
            if (left != right)
                parts[right] = parts.getOrDefault(right, listOf()).plus(left)
        }
        return parts
    }

    private fun bridge(left: Int, score: Int, length: Int, answers: MutableList<Pair<Int, Int>>) {
        val li = parts[left]
        if (li == null || li.isEmpty()) {
            answers.add(score to length)
            return
        }
        return li.forEach { right ->
//            println("$left/$right $score")
            parts[left] = li.minusElement(right)
            val ri = parts[right]!!
            if (left != right)
                parts[right] = ri.minusElement(left)
            bridge(right, score + left + right, length+1, answers)
            parts[left] = li
            if (left != right)
                parts[right] = ri
        }
    }
    fun answer1(): Int {
        val answers = mutableListOf<Pair<Int,Int>>()
        bridge(0, 0, 0, answers)
        return answers.map { it.first }.max()!!
    }

    fun answer2(): Int {
        val answers = mutableListOf<Pair<Int,Int>>()
        bridge(0, 0, 0, answers)
        val longest = answers.map { it.second }.max()!!
        return answers.filter { it.second == longest }.map { it.first }.max()!!
    }
}
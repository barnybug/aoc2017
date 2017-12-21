package aoc2017

class Day19(private val input: String) {
    private val grid = input.lines()
            .mapIndexed { y, line -> line.mapIndexed { x, c -> Pos(x, y) to c } }
            .flatMap { it }
            .filter { it.second != ' ' }
            .associate { it }
    private val letters = grid.filterValues { ('A'..'Z').contains(it) }

    fun sequence(): Sequence<Pos> {
        val start = grid.filterKeys { it.y == 0 }.keys.first()
        var dir = Pos.D
        var word = ""

        return generateSequence(start) { current ->
            val next = current + dir
            val c = grid.getOrDefault(next, ' ')
            when(c) {
                in 'A'..'Z' -> {
                    word += c
                    next
                }
                '+' -> {
                    // change direction
                    dir = if (grid.contains(next + dir.clockwise)) {
                        dir.clockwise
                    } else {
                        dir.anticlockwise
                    }
                    next
                }
                ' ' -> {
                    null
                }
                else -> next
            }
        }
    }

    fun answer1() = sequence().mapNotNull { letters[it] }.joinToString("")

    fun answer2() = sequence().count()

}
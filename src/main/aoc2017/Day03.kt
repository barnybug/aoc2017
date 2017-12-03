package aoc2017

class Day03(private val input: Int) {

    private fun path(): Sequence<Pos> {
        var p = Pos.Z
        var d = Pos.R

        return (1 until Int.MAX_VALUE).asSequence().flatMap {
            if (it == 1)
                listOf(p).asSequence()
            else {
                val steps = p.walk(d, it / 2)
                p += d * (it / 2)
                d = d.anticlockwise
                steps
            }
        }
    }

    fun answer1(): Int {
        return path().elementAt(input-1).size
    }

    fun answer2(): Int {
        val grid = mutableMapOf(Pos.Z to 1)
        return path().drop(1).map { p ->
            val total = p.adjacent().sumBy { grid.getOrDefault(it, 0) }
            grid[p] = total
            total
        }.first { it > input }
    }
}
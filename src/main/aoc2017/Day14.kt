package aoc2017

class Day14(private val input: String) {
    fun knotHash(value: String): List<Int> {
        val lengths = value.map { it.toInt() } + listOf(17, 31, 73, 47, 23)
        val size = 256
        val list = (0 until size).toMutableList()
        var position = 0
        var skip = 0
        (0 until 64).forEach {
            lengths.forEach { length ->
                (0 until length/2).forEach {
                    val a = (position + it) % size
                    val b = (position + length - 1 - it) % size
                    list.swap(a, b)
                }
                position += (length + skip) % size
                skip++
            }
        }

        return list.chunked(16).map {
            it.reduce { a, b -> a xor b }
        }
    }

    fun answer1() =
        (0 until 128).sumBy {
            knotHash("$input-$it").map { Integer.bitCount(it) }.sum()
        }

    fun answer2(): Int {
        val board = (0 until 128).flatMap { y ->
            val h = knotHash("$input-$y")
            val bits = h.flatMap { w -> (7 downTo 0).map { w and (1 shl it) != 0 } }
            bits.mapIndexedNotNull { i, b -> if (b) Pos(i, y) else null }
        }
        val used = board.toSet()
        var groups = listOf<Set<Pos>>()
        val s = mutableSetOf<Pos>()
        used.map { pos ->
            groups = if (!pos.adjacentWithoutDiagonals().any { s.contains(it) }) {
                // new group
                groups.plusElement(setOf(pos))
            } else {
                // combining existing group(s)
                val (matched, unmatched) = groups.partition { it.intersect(pos.adjacentWithoutDiagonals()).isNotEmpty() }
                val combined = matched.reduce { a, b -> a.union(b) }.plus(pos)
                unmatched.plusElement(combined)
            }
            s.add(pos)
        }
        return groups.size
    }
}
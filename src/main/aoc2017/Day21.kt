package aoc2017

class Board(private val bits: BooleanArray) {
    constructor(pattern: String): this(pattern.replace("/", "").map { it == '#' }.toBooleanArray())

    val width = Math.sqrt(bits.size.toDouble()).toInt()

    override fun hashCode(): Int {
        return bits.contentHashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Board)
            return bits.contentEquals(other.bits)
        return false
    }

    override fun toString(): String {
        return bits.toList().chunked(width).map { r ->
            r.map { if (it) '#' else '.' }.join()
        }.joinToString("\n")
    }

    fun flip() =
        Board(bits.toList().chunked(width).flatMap { it.reversed() }.toBooleanArray())

    fun rotate() = Board(
            (0 until width).flatMap { x ->
                (width-1 downTo 0).map { y ->
                    // (0, 2), (0, 1), (0, 0), (1, 2), (1, 1), (1, 0), (2, 2), (2, 1), (2, 0)
                    bits[x + y * width]
                }
            }.toBooleanArray())

    fun translations(): List<Board> {
        val ret = mutableListOf(this)
        ret.add(ret.last().rotate())
        ret.add(ret.last().rotate())
        ret.add(ret.last().rotate())
        ret.add(flip())
        ret.add(ret.last().rotate())
        ret.add(ret.last().rotate())
        ret.add(ret.last().rotate())
        return ret
    }

    fun subboard(sx: Int, sy: Int, size: Int) = Board(
            (sy until sy+size).flatMap { y ->
                (sx until sx+size).map { x -> bits[x + y * width]}
            }.toBooleanArray()
    )

    fun split(s: Int) =
        (0 until width step s).flatMap { y ->
            (0 until width step s).map { x ->
                subboard(x, y, s)
            }
        }

    fun popcount() = bits.count { it }

    companion object {
        fun concat(boards: List<Board>): Board {
            val n = Math.sqrt(boards.size.toDouble()).toInt()
            val bits = boards.chunked(n).flatMap { row ->
                val w = row[0].width
                (0 until w).flatMap { i ->
                    row.flatMap { b -> b.bits.slice(i*w until i*w+w) }
                }
            }
            return Board(bits.toBooleanArray())
        }
    }
}

class Day21(private val input: String) {
    val initial = Board(".#./..#/###")
    val rules = input.lines().associate { line ->
        val (left, right) = line.split(" => ")
        Board(left) to Board(right)
    }

    fun answer1(iterations: Int): Int {
        var current = initial
        (1..iterations).forEach {
            val cut = if (current.width % 2 == 0) 2 else 3
            val results = current.split(cut).map { b ->
                val rule = b.translations().mapNotNull {
                    rules[it] }.first()
                rule
            }
            current = Board.concat(results)
        }
        return current.popcount()
    }
    fun answer2() = input
}
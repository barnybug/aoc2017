package aoc2017

data class PosRange(override val start: Pos, override val endInclusive: Pos): ClosedRange<Pos>, Iterable<Pos> {
    override fun iterator(): Iterator<Pos> =
        (start.y..endInclusive.y).map { y ->
            (start.x..endInclusive.x).map { x -> Pos(x, y) }
        }.flatten().iterator()
}

data class Pos(val x: Int, val y: Int): Comparable<Pos> {
    override fun compareTo(other: Pos) =
        if (this == other) 0
        else if (x > other.x || x == other.x && y > other.y) 1
        else -1

    operator fun plus(a: Pos) = Pos(x + a.x, y + a.y)

    operator fun minus(a: Pos) = Pos(x - a.x, y - a.y)

    operator fun times(n: Int) = Pos(x*n, y*n)

    operator fun rangeTo(a: Pos) = PosRange(this, a-Pos(1, 1))

    fun adjacent() = listOf(Pos(1, 0), Pos(1, 1), Pos(0, 1), Pos(-1, 1), Pos(-1, 0), Pos(-1, -1), Pos(0, -1), Pos(1, -1)).map { this + it }

    fun adjacentWithoutDiagonals() = listOf(Pos(1, 0), Pos(0, 1), Pos(-1, 0), Pos(0, -1)).map { this + it }

    fun walk(direction: Pos, steps: Int) =
            (1..steps).asSequence().map { this + (direction * it) }

    val size: Int
        get() = Math.abs(x) + Math.abs(y)

    val clockwise get() = Pos(y, -x)
    val anticlockwise get() = Pos(-y, x)

    companion object {
        val Z = Pos(0, 0)
        val U = Pos(0, -1)
        val D = Pos(0, 1)
        val L = Pos(-1, 0)
        val R = Pos(1, 0)
    }
}
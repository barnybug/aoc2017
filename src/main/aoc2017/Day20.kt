package aoc2017

import kotlin.math.absoluteValue

typealias Pos3D = Triple<Int, Int, Int>

data class Particle(val p: Pos3D, val v: Pos3D, val a: Pos3D) {
    fun tick() = Particle(p+v+a, v+a, a)
}

operator fun Pos3D.plus(b: Pos3D) = Pos3D(first+b.first, second+b.second, third+b.third)

class Day20(private val input: String) {
    fun answer1() = input.lines().mapNotNull { line ->
        """a=<([-0-9]+),([-0-9]+),([-0-9]+)>""".toRegex().find(line)
    }.map { match ->
        manhattan(parse(match))
    }.withIndex().reversed().minBy { it.value }?.index

    private fun manhattan(p: Pos3D) =
        p.first.absoluteValue + p.second.absoluteValue + p.third.absoluteValue

    private fun parse(match: MatchResult): Pos3D {
        val (x, y, z) = match.groupValues.drop(1).map { it.toInt() }
        return Pos3D(x, y, z)
    }

    fun answer2(): Int {
        val particles = input.lines().map { line ->
            val (mp, mv, ma) = """<([-0-9]+),([-0-9]+),([-0-9]+)>""".toRegex().findAll(line).toList()
            val p = parse(mp)
            val v = parse(mv)
            val a = parse(ma)
            Particle(p, v, a)
        }

        val end = (0..100).fold(particles) { state, _ ->
            val next = state.map { it.tick() }
            val alive = next.groupBy { it.p }.filterValues { it.size == 1 }.values.flatten()
            alive
        }
        return end.size
    }
}
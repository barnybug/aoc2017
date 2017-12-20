package aoc2017

import kotlin.math.absoluteValue
import kotlin.math.max

class Day11(private val input: String) {
    fun steps(p: Pos) = if (p.x >= 0 )
        p.x.absoluteValue + max(p.y - p.x, 0)
    else
        p.x.absoluteValue + p.y

    fun positions(): List<Pos> {
        var p = Pos.Z
        return input.split(",").map {
            p += when(it) {
                "n" ->
                    Pos.U
                "s" ->
                    Pos.D
                "ne" ->
                    Pos.R
                "se" ->
                    Pos.R + Pos.D
                "nw" ->
                    Pos.L + Pos.U
                "sw" ->
                    Pos.L
                else ->
                    Pos.Z
            }
            p
        }
    }

    fun answer1() = steps(positions().last())

    fun answer2() = positions().map { steps(it) }.max()
}
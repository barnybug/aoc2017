package aoc2017

class Day22(private val input: String) {

    fun show(grid: Set<Pos>) {
        val minx = grid.minBy { it.x }!!.x
        val maxx = grid.maxBy { it.x }!!.x
        val miny = grid.minBy { it.y }!!.y
        val maxy = grid.maxBy { it.y }!!.y
        val s = (miny..maxy).map { y ->
            (minx..maxx).map { x ->
                if (grid.contains(Pos(x, y))) '#' else '.'
            }.join()
        }.joinToString("\n")
        println(s)
    }

    fun answer1(bursts: Int): Int {
        val centre = Pos( (input.lines().first().length)/2, (input.lines().size)/2)
        val grid = input.lines()
                .mapIndexed { y, line -> line.mapIndexed { x, c -> Pos(x-centre.x, y-centre.y) to c } }
                .flatten()
                .filter { it.second == '#' }
                .map { it.first }.toMutableSet()

        var infections = 0
        var virus = Pos.Z
        var dir = Pos.U
        (1..bursts).forEach {
            if (grid.contains(virus)) {
                dir = dir.anticlockwise
                grid.remove(virus)
            }
            else {
                dir = dir.clockwise
                grid.add(virus)
                infections++
            }
            virus += dir
        }

        return infections
    }

    fun answer2(bursts: Int): Int {
        val centre = Pos( (input.lines().first().length)/2, (input.lines().size)/2)
        val grid = input.lines()
                .mapIndexed { y, line -> line.mapIndexed { x, c -> Pos(x-centre.x, y-centre.y) to c } }
                .flatten()
                .filter { it.second == '#' }
                .associate { it }
                .toMutableMap()

        var infections = 0
        var virus = Pos.Z
        var dir = Pos.U
        (1..bursts).forEach {
            when(grid[virus]) {
                'W' -> {
                    grid[virus] = '#'
                    infections++
                }
                '#' -> {
                    grid[virus] = 'F'
                    dir = dir.anticlockwise
                }
                'F' -> {
                    grid.remove(virus)
                    dir = Pos.Z-dir
                }
                else -> {
                    grid[virus] = 'W'
                    dir = dir.clockwise
                }
            }
            virus += dir
        }

        return infections
    }
}
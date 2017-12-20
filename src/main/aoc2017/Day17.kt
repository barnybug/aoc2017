package aoc2017

class Day17(private val input: Int) {
    fun answer1(): Int {
        val buffer = mutableListOf(0)
        var pos = 0
        (1..2017).forEach { i ->
            pos = (pos + input + 1) % buffer.size
            buffer.add(pos+1, i)
        }
        return buffer[buffer.indexOf(2017)+1]
    }

    fun answer2(): Int {
        var pos = 0
        var zeroPos = 0
        var afterZero = 0
        (1..50000000).forEach { i ->
            pos = (pos + input + 1) % i
            if (pos == zeroPos)
                afterZero = i
            else if (pos < zeroPos)
                zeroPos--
        }
        return afterZero
    }
}
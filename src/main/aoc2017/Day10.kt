package aoc2017

class Day10(private val input: String, val size: Int = 256) {

    fun answer1(): Int {
        val lengths = input.split(",").map { it.toInt() }
        val list = (0 until size).toMutableList()
        var position = 0
        lengths.forEachIndexed { skip, length ->
            (0 until length/2).forEach {
                val a = (position + it) % size
                val b = (position + length - 1 - it) % size
                list.swap(a, b)
            }
            position += (length + skip) % size
        }
        return list[0] * list[1]
    }

    fun answer2(): String {
        val lengths = input.map { it.toInt() } + listOf(17, 31, 73, 47, 23)
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

        val dense = list.chunked(16).map {
            it.reduce { a, b -> a xor b }
        }
        return dense.map { "%02x".format(it) }.join()
    }
}
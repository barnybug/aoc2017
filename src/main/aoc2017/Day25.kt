package aoc2017

class Day25(private val input: String) {
    fun answer1(): Int {
        var state = "Begin in state (.)".toRegex().find(input)!!.groupValues[1][0] - 'A'
        val steps = "after (\\d+) steps".toRegex().find(input)!!.groupValues[1].toInt()
        val matches = "In state (.).+?If the current value is 0:.+?Write the value ([01]).+?Move one slot to the (right|left).+?Continue with state (.).+?If the current value is 1:.+?Write the value ([01]).+?Move one slot to the (right|left).+?Continue with state (.)".toRegex(RegexOption.DOT_MATCHES_ALL).findAll(input)
        val states = matches.map { m ->
            val (_, fv, fd, fs, tv, td, ts) = m.destructured
            listOf(
                    fv.toInt(),
                    if (fd == "right") 1 else -1,
                    fs[0] - 'A',
                    tv.toInt(),
                    if (td == "right") 1 else -1,
                    ts[0] - 'A'
            )
        }.toList()

        val tape = mutableSetOf<Int>()
        var tc = 0
        (1..steps).forEach {
            val a = states[state]
            if (!tape.contains(tc)) {
                if (a[0] == 1)
                    tape.add(tc)
                tc += a[1]
                state = a[2]
            } else {
                if (a[3] == 0)
                    tape.remove(tc)
                tc += a[4]
                state = a[5]
            }
        }
        return tape.size
    }
    fun answer2() = input
}
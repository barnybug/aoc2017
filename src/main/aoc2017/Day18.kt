package aoc2017

data class Instruction(val t: String, val args: List<String>) {
    val X: String get() = args[0]
    val Y: String get() = args[1]
}

class Program(val ins: List<Instruction>, var regs: MutableMap<String, Long>, var inputs: MutableList<Long>, var outputs: MutableList<Long>, val mode: Int) {
    var pc = 0
    var sends = 0

    private fun read(value: String): Long {
        val i = value.toLongOrNull()
        if (i != null)
            return i
        return regs.getOrDefault(value, 0)
    }

    fun execute(): Boolean {
        val c = ins[pc]
        when (c.t) {
            "snd" -> {
                sends++
                outputs.add(read(c.X))
            }
            "set" ->
                regs[c.X] = read(c.Y)
            "add" ->
                regs[c.X] = read(c.X) + read(c.Y)
            "mul" ->
                regs[c.X] = read(c.X) * read(c.Y)
            "mod" ->
                regs[c.X] = read(c.X) % read(c.Y)
            "rcv" -> {
                if (mode == 0) {
                    if (read(c.X) != 0L)
                        return false
                } else {
                    if (inputs.isEmpty())
                        return false
                    regs[c.X] = inputs.first()
                    inputs.removeAt(0)
                }
            }
            "jgz" -> {
                if (read(c.X) > 0L)
                    pc += read(c.Y).toInt()-1
            }
        }
        pc++
        return true
    }
}

class Day18(private val input: String) {
    val ins = input.lines().map { line ->
        val l = line.split(" ")
        Instruction(l[0], l.slice(1 until l.size))
    }

    fun answer1(): Long {
        val prog = Program(ins, mutableMapOf(), mutableListOf(), mutableListOf(), 0)
        while(prog.execute()) {
        }
        return prog.outputs.last()
    }

    fun answer2(): Int {
        val p1 = Program(ins, mutableMapOf("p" to 0L), mutableListOf(), mutableListOf(), 1)
        val p2 = Program(ins, mutableMapOf("p" to 1L), p1.outputs, p1.inputs, 1)

        var deadlocked = false
        while(!deadlocked) {
            deadlocked = true
            while(p1.execute()) {
                deadlocked = false
            }
            while(p2.execute()) {
                deadlocked = false
            }
        }
        return p2.sends
    }
}
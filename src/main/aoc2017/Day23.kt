package aoc2017

class Day23Program(val ins: List<Instruction>, var regs: MutableMap<String, Long>) {
    private var pc = 0
    var mulCount = 0

    private fun read(value: String): Long {
        val i = value.toLongOrNull()
        if (i != null)
            return i
        return regs.getOrDefault(value, 0)
    }

    fun run(a: Int) {
        var b = 99 // set b 99
        var c = b // set c b
        var h = 0

        if (a != 0) { // jnz a 2 // jnz 1 5
            b = b*100 + 100000 // mul b 100 // sub b -100000
            c = b + 17000 // set c b // sub c -17000
        }
        for(x in b..c step 17) {
            for(d in 2 until x) {
                if (x % d == 0) {
                    h++
                    break
                }
            }
        }
        regs["h"] = h.toLong()
    }

    fun interpret() {
        mulCount = 0
        while (pc < ins.size) {
            val c = ins[pc]
//            if (pc >= 28)
//                println("B $regs ($c)")
            when (c.t) {
                "set" ->
                    regs[c.X] = read(c.Y)
                "sub" ->
                    regs[c.X] = read(c.X) - read(c.Y)
                "mul" -> {
                    mulCount++
                    regs[c.X] = read(c.X) * read(c.Y)
                }
                "jnz" ->
                    if (read(c.X) != 0L)
                        pc += read(c.Y).toInt() - 1
                "mod" ->
                    regs[c.X] = read(c.Y) % read(c.Z)
            }
            pc++
        }
        println("$regs")
    }
}

class Day23(private val input: String) {
    val ins = input.lines().map { Instruction.parse(it) }

    fun answer1(): Int {
        val p = Day23Program(ins, mutableMapOf<String, Long>("a" to 0, "b" to 0, "c" to 0, "d" to 0, "e" to 0, "f" to 0, "g" to 0, "h" to 0))
        p.run(0)
        return p.mulCount
    }

    fun answer2(): Int {
        val p = Day23Program(ins, mutableMapOf<String, Long>("a" to 1))
        p.run(1)
        return p.regs["h"]!!.toInt()
    }
}
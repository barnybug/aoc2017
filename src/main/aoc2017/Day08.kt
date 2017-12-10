package aoc2017

class Day08(private val input: String) {
    data class Op(val reg: String, val op: String, val value: Int) {
        fun check(state: State) = when(op) {
            ">" -> state[reg] > value
            "<" -> state[reg] < value
            ">=" -> state[reg] >= value
            "<=" -> state[reg] <= value
            "==" -> state[reg] == value
            "!=" -> state[reg] != value
            else -> false
        }

        fun execute(state: State) {
            when(op) {
                "inc" -> state[reg] += value
                "dec" -> state[reg] -= value
            }
        }

        companion object {
            fun create(s: String): Op {
                val (reg, op, value) = s.split(" ")
                return Op(reg, op, value.toInt())
            }
        }
    }

    data class Instruction(val action: Op, val condition: Op)

    class State {
        private val register = mutableMapOf<String, Int>()
        operator fun get(r: String) = register.getOrDefault(r, 0)
        operator fun set(r: String, value: Int) { register[r] = value }

        fun maximumInRegister() = register.values.max() ?: 0
    }

    private fun instructions() = input.lines().map { line ->
        val (left, right) = line.split(" if ")
        Instruction(Op.create(left), Op.create(right))
    }

    fun answer1(): Int {
        val state = State()
        instructions().forEach { i ->
            if (i.condition.check(state))
                i.action.execute(state)
        }
        return state.maximumInRegister()
    }

    fun answer2(): Int {
        val state = State()
        return instructions().map { i ->
            if (i.condition.check(state))
                i.action.execute(state)
            state.maximumInRegister()
        }.max()!!
    }
}
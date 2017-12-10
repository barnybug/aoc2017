package aoc2017

data class Rule(val left: String, val weight: Int, val children: List<String>)

class Day07(private val input: String) {
    private val reRule = """(\w+) \((\d+)\)(?: -> (.+))?""".toRegex()
    private val rules = parsed()

    private fun parsed() = input.lines().map { line ->
        val m = reRule.find(line)!!
        val (left, weight, children) = m.destructured
        val c = if (children.isNotEmpty()) children.split(", ") else listOf()
        Rule(left, weight.toInt(), c)
    }.associateBy { it.left }

    fun answer1(): String {
        val all = rules.keys
        val right = rules.flatMap { it.value.children }.toSet()
        return (all - right).first()
    }

    class Answer(val correct: Int): Exception()

    private fun check(left: String): Int {
        val rule = rules[left]!!
        if (rule.children.isEmpty()) return rule.weight

        val values = rule.children.map { check(it) }
        val keys = values.groupBy { it }.filter { it.value.size == 1 }.keys
        if (keys.size == 1) {
            val incorrect = keys.first()
            val i = values.indexOf(incorrect)
            val others = values.find { it != incorrect }!!
            val child = rules[rule.children[i]]!!
            throw Answer(child.weight - incorrect + others)
        }
        return values.sum() + rule.weight
    }

    fun answer2(): Int {
        try {
            check(answer1())
        } catch (a: Answer) {
            return a.correct
        }
        return 0
    }
}
package day01

class Solution : utils.Solution() {
    private fun puzzle(divide: Int): String {
        val n = inputText().map { "$it".toInt() }
        val pairs = n.zip(n.takeLast(divide) + n.take(n.size-divide))
        val answer = pairs.sumBy { (a, b) -> if (a == b) a else 0 }
        return answer.toString()
    }

    override fun answer1(): String = puzzle(1)
    override fun answer2(): String = puzzle(inputText().length/2)
}

fun main(args: Array<String>) {
    Solution().run()
}
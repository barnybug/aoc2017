package utils

import java.io.File

abstract class Solution {
    private fun packageName() = this::class.qualifiedName!!.removeSuffix("." + this::class.simpleName!!)

    fun inputFile(): File =
            File("src/${packageName()}/input.txt")

    fun inputLines(): List<String> =
            inputFile().readLines()

    fun inputText(): String =
            inputFile().readText()

    open fun answer1() = ""
    open fun answer2() = ""

    fun run() {
        println("Answer 1: ${answer1()}")
        println("Answer 2: ${answer2()}")
    }
}

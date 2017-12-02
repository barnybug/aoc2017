package aoc2017

import kotlin.coroutines.experimental.buildSequence

fun <T> List<T>.combination(k: Int) = buildSequence {
    val list = this@combination

    if (k > list.size)
        return@buildSequence

    // first index sequence: 0, 1, 2, ...
    val ix = (0 until k).toList().toIntArray()
    yield(subset(list, ix))

    while (true) {
        var i = k - 1
        // find position of item that can be incremented
        while (i >= 0 && ix[i] == list.size - k + i) {
            i--
        }
        if (i < 0) {
            break
        }
        ix[i]++ // increment this item
        ++i
        while (i < k) { // fill up remaining items
            ix[i] = ix[i - 1] + 1
            i++
        }
        yield(subset(list, ix))
    }
}

// generate subset by index sequence
fun <T> subset(input: List<T>, indices: IntArray): List<T> = indices.map { input[it] }

fun <T> List<T>.permute(k: Int) = buildSequence {
    val list = this@permute

    if (k > list.size)
        return@buildSequence

    // first index sequence: 0, 1, 2, ...
    val ix = (0 until k).toList().toIntArray()
    yield(subset(list, ix))

    while (true) {
        var i = k - 1
        // find position of item that can be incremented
        while (i >= 0 && ix[i] == list.size - k + i) {
            i--
        }
        if (i < 0) {
            break
        }
        ix[i]++ // increment this item
        ++i
        while (i < k) { // fill up remaining items
            ix[i] = ix[i - 1] + 1
            i++
        }
        yield(subset(list, ix))
    }
}


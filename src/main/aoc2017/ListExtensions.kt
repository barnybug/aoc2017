package aoc2017

/**
 * Generate the combinations of a List.
 */
fun <T> List<T>.combination(k: Int): Sequence<List<T>> {
    val ix = (0 until k).toList().toIntArray()
    ix[k-1]-- // first run through increments once
    return generateSequence {
        var i = k - 1
        // find position of item that can be incremented
        while (i >= 0 && ix[i] == this.size - k + i) {
            i--
        }
        if (i < 0) return@generateSequence null
        ix[i]++ // increment this item
        ++i
        while (i < k) { // fill up remaining items
            ix[i] = ix[i - 1] + 1
            i++
        }
        return@generateSequence subset(this, ix)
    }
}

// generate subset by index sequence
fun <T> subset(input: List<T>, indices: IntArray): List<T> = indices.map { input[it] }

/**
 * Generate the permutations of a List.
 */
fun <T> List<T>.permute(k: Int): Sequence<List<T>> {
    val indices = (0 until size).toList().toIntArray()
    val cycles = (size downTo (size-k+1)).toList().toIntArray()
    var first = true
    var i = k - 1
    return generateSequence {
        if (first) {
            first = false
            return@generateSequence subset(this, indices.sliceArray(0 until k))
        }
        while(i >= 0) {
                cycles[i]--
                if (cycles[i] == 0) {
                    val tmp = indices[i]
                    System.arraycopy(indices, i+1, indices, i, size-i-1)
                    indices[size-1] = tmp
                    cycles[i] = size - i
                } else {
                    val j = cycles[i]
                    indices[i] = indices[size-j].also { indices[size-j] = indices[i] }
                    i = k - 1
                    return@generateSequence subset(this, indices.sliceArray(0 until k))
                }
                i -= 1
            }
        return@generateSequence null
    }
}

// Cycle the list n elements 'rightwards'
fun <T> List<T>.cycle(n: Int): List<T> =
        if (n < 0)
            takeLast(size+(n % size)) + take(-(n % size))
        else
            takeLast(n % size) + take(size-(n % size))

// Return sliding window of sublists of size n eg listOf(1, 2, 3, 4).window(2) => [[1, 2], [2, 3], [3, 4]]
fun <T> List<T>.window(n: Int): List<List<T>> =
        (0..size-n).map { subList(it, it+n) }

fun <T> List<T>.join() = this.joinToString("")

fun <T> MutableList<T>.swap(a: Int, b: Int) {
    this[a] = this[b].also { this[b] = this[a] }
}

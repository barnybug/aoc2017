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
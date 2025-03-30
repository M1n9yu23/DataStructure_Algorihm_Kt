package ch01.exam

private fun max4(a: Int, b: Int, c: Int, d: Int): Int {
    var max = a

    if (b > max) {
        max = b
    }

    if (c > max) {
        max = c
    }

    if (d > max) {
        max = d
    }

    return max
}

private fun min3(a: Int, b: Int, c: Int): Int {
    var min = a

    if (b < min) {
        min = b
    }

    if (c < min) {
        min = c
    }

    return min
}


private fun min4(a: Int, b: Int, c: Int, d: Int): Int {
    var min = a

    if (b < min) {
        min = b
    }

    if (c < min) {
        min = c
    }

    if (d < min) {
        min = d
    }

    return min
}

fun main() {
    println(max4(3,1,2,5))
    println(min3(3,1,2,))
    println(min4(3,3,2,5))
}
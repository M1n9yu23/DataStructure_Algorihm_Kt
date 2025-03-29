package ch01

private fun max3(a: Int, b: Int, c: Int): Int {
    var max = a

    if(b > max) {
        max = b
    }
    if(c > max) {
        max = c
    }

    return max
}

fun main() {
    println(max3(3,2,1))
    println(max3(2,10,1))
    println(max3(1,2,3))
    println(max3(3,5,5))
}
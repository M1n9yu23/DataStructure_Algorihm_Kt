package ch02

fun main() {
    val a = intArrayOf(1,2,3,4,5)
    val b = a.copyOf()

    b[3] = 0

    println("a = ${a.joinToString()}")
    println("b = ${b.joinToString()}")
}
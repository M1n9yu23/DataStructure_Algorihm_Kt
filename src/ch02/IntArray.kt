package ch02

private fun intArray() {
    val a = IntArray(5)

    a[1] = 37
    a[2] = 51
    a[4] = a[1] * 2

    println("${a.indices}") // a의 인덱스 범위

    for (i in a.indices) {
        println("a[$i] = ${a[i]}")
    }
}

fun main() {
    intArray()
}
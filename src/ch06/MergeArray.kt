package ch06

private fun merge(a: IntArray, b: IntArray, c: IntArray) {
    var pa = 0
    var pb = 0
    var pc = 0

    while (pa < a.size && pb < b.size) {
        c[pc++] = if (a[pa] <= b[pb]) a[pa++] else b[pb++]
    }

    while (pa < a.size) {
        c[pc++] = a[pa++]
    }

    while (pb < b.size) {
        c[pc++] = b[pb++]
    }
}

fun main() {
    val a = intArrayOf(2, 4, 6, 8, 11, 13)
    val b = intArrayOf(1, 2, 3, 4, 9, 16, 21)
    val c = IntArray(a.size + b.size)

    println("두 배열을 병합")

    merge(a, b, c)

    println("배열 a와 b를 병합하여 배열 c에 저장했습니다.")
    println("배열 a: ")
    a.forEachIndexed { i, e ->
        println("a[$i] = ${e}")
    }
    println("배열 b: ")
    b.forEachIndexed { i, e ->
        println("b[$i] = ${e}")
    }

    println("배열 c: ")
    c.forEachIndexed { i, e ->
        println("c[$i] = ${e}")
    }
}
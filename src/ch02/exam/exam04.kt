package ch02.exam

private fun copy(a: IntArray, b: IntArray) {
    for (i in 0 until b.size) {
        a[i] = b[i]
    }
}

fun main() {
    print("n: ")
    val n = readln().toInt()

    val b = IntArray(n)

    for (i in 0 until b.size) {
        print("b[$i]: ")
        b[i] = readln().toInt()
    }

    val a = IntArray(n)

    println("a[${a.joinToString()}]")
    println("b[${b.joinToString()}]")

    println("모든 요소를 복사합니다.")
    copy(a, b)

    println("a[${a.joinToString()}]")
    println("b[${b.joinToString()}]")
}
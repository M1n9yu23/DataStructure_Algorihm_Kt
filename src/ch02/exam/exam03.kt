package ch02.exam

private fun sumOf(a: IntArray): Int {
    var sum = 0

    for (i in a) {
        sum += i
    }

    return sum
}

fun main() {
    println("요소의 합계를 구합니다.")
    print("n: ")
    val n = readln().toInt()

    val a = IntArray(n)

    for (i in 0 until a.size) {
        print("a[$i]: ")
        a[i] = readln().toInt()
    }

    println("모든 요소의 합계: ${sumOf(a)}")
}
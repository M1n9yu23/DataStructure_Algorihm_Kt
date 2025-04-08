package ch02.exam

private fun rcopy(a: IntArray, b: IntArray) {
    val n = b.size
    if(n % 2 == 1) {
        a[n / 2] = b[n / 2]
    }

    for(i in 0 until n / 2) {
        a[i] = b[n - i - 1]
        a[n - i - 1] = b[i]
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

    println("모든 요소를 역순으로 복사합니다.")
    rcopy(a, b)

    println("a[${a.joinToString()}]")
    println("b[${b.joinToString()}]")
}
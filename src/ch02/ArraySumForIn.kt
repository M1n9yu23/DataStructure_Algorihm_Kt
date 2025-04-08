package ch02

fun main() {
    val a = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)

    for(i in 0 until a.size) {
        println("a[$i] = ${a[i]}")
    }

    var sum = 0.0
    for(i in a) {
        sum += i
    }

    println("모든 요소의 합은 $sum 입니다.")
}
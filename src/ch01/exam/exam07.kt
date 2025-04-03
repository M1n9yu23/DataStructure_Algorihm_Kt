package ch01.exam

private fun gauss() {
    print("n: ")
    val n = readln().toInt()

    var sum = n * (n + 1) / 2

    println("1부터 n까지의 합은: $sum")
}

fun main() {
    gauss()
}
package ch05

private fun recur(x: Int) {
    var localX = x
    while(localX > 0) {
        recur(localX - 1)
        println(localX)
        localX -= 2
    }
}

fun main() {
    val x = readln().toInt()

    println(recur(x))
}
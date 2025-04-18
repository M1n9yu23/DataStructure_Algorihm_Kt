package ch05

private fun recur(n: Int) {
    if(n > 0){
        recur(n - 1)
        println(n)
        recur(n - 2)
    }
}

fun main() {
    val x = readln().toInt()

    recur(x)
}
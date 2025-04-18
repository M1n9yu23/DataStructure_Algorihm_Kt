package ch05

private fun factorial(x: Int): Int {
    return if(x > 0) {
        x * factorial(x - 1)
    }
    else {
        1
    }
}

fun main() {
    val x = readln().toInt()

    println("$x 의 팩토리얼은 ${factorial(x)}입니다.")
}
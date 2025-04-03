package ch01.exam

private fun exam15(){
    var n = -1

    println("n단의 피라미드를 출력합니다.")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) { // i = 1, 2, ... , n
        print(" ".repeat(n - i))
        print("*".repeat((i * 2) - 1) )
        // (i - 1) * 2 + 1 == (i * 2) - 1
        // 2i - 1 == 2i - 1로 나옴 둘다.
        println()
    }
}

fun main() {
    exam15()
}
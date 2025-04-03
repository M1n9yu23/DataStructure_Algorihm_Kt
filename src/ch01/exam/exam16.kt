package ch01.exam

private fun exam16(){
    var n = -1

    println("n단의 숫자 피라미드를 출력합니다.")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print(" ".repeat(n - i))
        print("${i % 10}".repeat((i * 2) - 1))
        // 10단을 넘어가면 보기 힘들게 출력이 돼서 0~9 만 보이도록 함.
        println()
    }
}

fun main() {
    exam16()
}
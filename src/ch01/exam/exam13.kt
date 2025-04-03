package ch01.exam

private fun exam13(){
    var n = -1

    println("정사각형을 출력합니다.")

    do {
        print("변의 길이: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print("*".repeat(n))
        println()
    }
}

fun main() {
    exam13()
}
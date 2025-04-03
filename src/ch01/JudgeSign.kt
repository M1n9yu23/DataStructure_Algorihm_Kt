package ch01

fun main() {
    println("정수를 입력하세요: ")
    val n = readln().toInt()

    if(n > 0) {
        println("이 수는 양수입니다.")
    } else if(n < 0) {
        println("이 수는 음수입니다.")
    } else {
        println("이 수는 0입니다.")
    }
}
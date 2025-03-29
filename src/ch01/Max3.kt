package ch01

fun main() {
    println("세 정수의 최댓값을 구합니다.")

    print("a의 값: ")
    val a = readln().toInt()
    print("b의 값: ")
    val b = readln().toInt()
    print("c의 값: ")
    val c = readln().toInt()

    var max = a

    if(b > max) {
        max = b
    }
    if(c > max) {
        max = c
    }

    println("최댓값은 $max 입니다.")


}
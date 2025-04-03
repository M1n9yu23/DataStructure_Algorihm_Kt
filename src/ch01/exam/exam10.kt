package ch01.exam

private fun exam10(){
    print("n: ")
    var n = readln().toInt()

    while(n <= 0) {
        print("양의 정수를 입력하세요.")
        n = readln().toInt()
    }

    val digit = n.toString()

    // or
//
//    var digit = 0
//    while(n > 0) {
//        n /= 10 1 / 10 = 0
//        digit++ 1자리
//    }

    println("그 수는 ${digit.length}자리입니다.")
}

fun main() {
    exam10()
}
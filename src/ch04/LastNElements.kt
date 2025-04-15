package ch04

fun main() {
    val n = 10
    val a = IntArray(n)
    var cnt = 0
    var retry: Int?

    println("정수를 입력하세요")

    do {
        print("${cnt + 1}번째 정수: ")
        a[cnt++ % n] = readln().toInt()
        // 30 % 10 = 0 31 % 10 = 1

        print("계속 할까요? (예.1 / 아니요.0): ")
        retry = readln().toInt()
    } while(retry == 1)

    var i = cnt - n
    // cnt = 5이면 i = -5
    // cnt = 12이면 i = 2
    if(i < 0) i = 0
    // i를 0으로 대입
    // cnt가 12일 땐 조건 X

    // 0 ~ 5 - 1
    // 2 ~ 12 - 1
    for(j in i until cnt) {
        println("%2d번째 정수 = ${a[j % n]}".format(j + 1))
    }
}
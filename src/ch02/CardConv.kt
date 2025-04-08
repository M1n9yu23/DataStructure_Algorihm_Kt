package ch02

// x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어 두고 자릿수를 반환
private fun cardConv(x: Int, r: Int, d: CharArray): Int {
    var digits = 0 // 변환 후의 자릿수
    var cloneX = x
    val dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    do {
        d[digits++] = dChar[cloneX % r] // r로 나눈 나머지를 저장
        // 코틀린에서는 문자열도 인덱스로 접근 가능한 컬렉션 즉 charAt 필요없음 아예 제공도 안함.
        cloneX /= r
    } while(cloneX != 0)

    for(i in 0 until digits / 2) {
        val t = d[i]
        d[i] = d[digits - i - 1]
        d[digits - i - 1] = t
    }

    return digits
}

fun main() {
    var no = -1 // 변환하는 정수
    var cd = -1 // 기수
    var dno = -1 // 변환 후의 자릿수
    var retry = -1 // 다시 한번?
    val cno = CharArray(32) // 변환 후 각 자리의 숫자를 넣어 두는 문자 배열

    println("10진수를 기수 변환합니다.")
    do {
        do {
            print("변환하는 음이 아닌 정수: ")
            no = readln().toInt()
        } while (no < 0)

        do {
            print("어떤 진수로 변환할까요? (2~36): ") // dChar 길이가 36
            cd = readln().toInt()
        } while (cd < 2 || cd > 36)

        dno = cardConv(no, cd, cno)

        print("$cd 진수로 ")
        for (i in 0 until dno) {
            print(cno[i])
        }
        println("입니다.")

        print("한 번 더 할까요? (1..예/0..아니요): ")
        retry = readln().toInt()
    } while(retry == 1)
}
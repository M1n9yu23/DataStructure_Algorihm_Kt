package ch02.exam

private fun cardConv(x: Int, r: Int, d: CharArray): Int {
    var digits = 0
    var cloneX = x
    val dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    println("%2d | %4d".format(r,cloneX))
    do {
        println("%2s + -------".format(""))
        if(cloneX / r != 0) {
            println("%2d | %4d    ... %d".format(r,cloneX / r, cloneX % r))
        } else {
            println("%2s | %4d    ... %d".format("",cloneX / r,cloneX % r))
        }

        d[digits++] = dChar[cloneX % r]
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
    var no = -1
    var cd = -1
    var dno = -1
    val cno = CharArray(32)

    println("10진수를 기수 변환합니다.")

        do {
            print("변환하는 음이 아닌 정수: ")
            no = readln().toInt()
        } while (no < 0)

        do {
            print("어떤 진수로 변환할까요? (2~36): ")
            cd = readln().toInt()
        } while (cd < 2 || cd > 36)

        dno = cardConv(no, cd, cno)

        print("${cd}진수로")
        for(i in 0 until dno) {
            print(cno[i])
        }
        println("입니다.")

}
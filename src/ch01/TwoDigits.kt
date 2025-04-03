package ch01

private fun twoDigits(){
    var no = -1

    println("2자리의 양수를 입력하세요.")

    do {
        print("no: ")
        no = readln().toInt()
    } while (!(no in 10..99))

    println("변수 no값은 $no 입니다.")

}

fun main() {
    twoDigits()
}
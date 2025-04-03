package ch01

private fun sumWhile(){
    println("1부터 n까지의 합을 구합니다.")
    print("n값: ")
    val n = readln().toInt()

    var sum = 0
    var i = 1

    while(i <= n) {
        sum += i
        i++
    }

    println("변수 i값: $i")

    println("1부터 $n 까지의 합은 $sum 입니다.")
}

fun main() {
    sumWhile()
}
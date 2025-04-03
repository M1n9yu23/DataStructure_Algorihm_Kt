package ch01

private fun sumFor2(){
    println("1부터 n까지의 합을 구합니다.")

    var n = -1
    var sum = 0

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        sum += i
    }

    println("1부터 $n 까지의 합은 $sum 입니다.")
}

fun main() {
    sumFor2()
}
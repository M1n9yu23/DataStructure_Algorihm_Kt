package ch01

private fun sumFor(){
    println("1부터 n까지의 합을 구합니다.")
    print("n: ")
    val n = readln().toInt()

    var sum = 0

    for(i in 1..n) {
        sum += i
    }

    println("1부터 $n 까지의 합은 $sum 입니다.")
}
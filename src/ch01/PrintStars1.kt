package ch01

private fun printStars(){

    println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.")

    var n = -1
    var w = -1

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    do {
        print("w: ")
        w = readln().toInt()
    } while(w <= 0 || w > n)


    for(i in 0 until n) {
        print("*")
        if(i % w == w - 1)
            println()
    }

    if(n % w != 0)
        println()

}

private fun printStars2(){
    println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.")

    var n = -1
    var w = -1

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    do {
        print("w: ")
        w = readln().toInt()
    } while(w <= 0 || w > n)

    for(i in 0 until n / w) {
        println("*".repeat(w))
    }

    val rest = n % w

    if(rest != 0) {
        println("*".repeat(rest))
    }
}

fun main() {
    printStars()
    printStars2()
}
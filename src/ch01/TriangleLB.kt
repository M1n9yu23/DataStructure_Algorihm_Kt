package ch01

private fun triangleLB(){
    var n = -1

    println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다.")

    do {
        print("몇 단 삼각형입니까?: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n){
        for(j in 1..i){
            print("*")
        }
        println()
    }
}

fun main() {
    triangleLB()
}
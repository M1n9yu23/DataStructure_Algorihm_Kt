package ch01.exam

private fun triangleLB(){
    var n = -1

    println("왼쪽 아래가 직각인 이등변 삼각형")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print("*".repeat(i))
        println()
    }
}

private fun triangleLU(){
    var n = -1

    println("왼쪽 위가 직각인 이등변 삼각형")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print("*".repeat((n - i) + 1))
        println()
    }
}

private fun triangleRU(){
    var n = -1

    println("오른쪽 위가 직각인 이등변 삼각형")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print(" ".repeat(i-1))
        print("*".repeat((n - i) + 1))
        println()
    }
}

private fun triangleRB(){
    var n = -1

    println("오른쪽 아래가 직각인 이등변 삼각형")

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    for(i in 1..n) {
        print(" ".repeat(n-i))
        print("*".repeat(i))
        println()
    }
}

fun main() {
    triangleRB()
}
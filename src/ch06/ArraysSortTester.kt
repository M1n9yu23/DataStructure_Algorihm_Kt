package ch06

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    x.sort()

    println()
    for(i in x.indices)
        println("x[$i] = ${x[i]}")
}
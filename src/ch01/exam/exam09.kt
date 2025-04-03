package ch01.exam

private fun exam9(){
    var a = -1
    var b = -1

    do {
        print("a: ")
        a = readln().toInt()

        print("b: ")
        b = readln().toInt()

        if(a <= b) {
            println("a보다 큰 값을 입력하세요!")
        }

    } while(a >= b)

    val result = b - a

    println("$b - $a = $result")
}

fun main() {
    exam9()
}
package ch01.exam

private fun sumOf(a: Int, b: Int) {
    var sum = 0

    if(a > b) {
        for(i in b..a) {
            sum += i
        }
    } else {
        for(i in a..b) {
            sum += i
        }
    }


    println("$a 부터 $b 사이의 정수 합: $sum")
}

fun main() {
    sumOf(6,4)
}
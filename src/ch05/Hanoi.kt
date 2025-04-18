package ch05

private fun move(no: Int, x: Int, y: Int) {
    if(no > 1) {
        move(no - 1, x, 6 - x - y)
    }

    println("원반[$no]을 $x 번 기둥에서 $y 번 기둥으로 옮김")

    if(no > 1) {
        move(no - 1, 6 - x - y, y)
    }
}

fun main() {
    val n = readln().toInt()

    move(n,1,3)
}
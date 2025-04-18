package ch05

import ch04.IntStack

private fun recur(x: Int) {
    val s = IntStack(x)
    var localX = x
    while(true) {
        if(localX > 0) {
            s.push(localX)
            localX -= 1
            continue
        }
        if(!s.isEmpty()) {
            localX = s.pop()
            println(localX)
            localX -= 2
            continue
        }
        break
    }
}

fun main() {
    val x = readln().toInt()
    recur(x)
}
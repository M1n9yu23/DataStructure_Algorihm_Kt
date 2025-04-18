package ch05

private val pos = IntArray(8)

private fun print(){
    for(i in 0 until 8) {
        print("%2d".format(pos[i]))
    }
    println()
}

private fun set(i: Int) {
    for(j in 0 until 8) {
        pos[i] = j
        if(i == 7) print()
        else set(i + 1)
    }
}


fun main() {
    set(0)
}